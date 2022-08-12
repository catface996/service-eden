package com.catface.eden.service.client.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.eden.common.enums.ClientStatusEnum;
import com.catface.eden.repository.entity.Client;
import com.catface.eden.repository.entity.User;
import com.catface.eden.repository.entity.UserToClient;
import com.catface.eden.repository.param.QueryUserToClientParam;
import com.catface.eden.repository.service.ClientRpService;
import com.catface.eden.repository.service.UserRpService;
import com.catface.eden.repository.service.UserToClientRpService;
import com.catface.eden.service.client.ClientService;
import com.catface.eden.service.client.param.BindUserToClientParam;
import com.catface.eden.service.client.param.CreateClientParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author catface
 * @since 2022/8/11
 */
@Slf4j
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRpService clientRpService;

    private final UserRpService userRpService;

    private final UserToClientRpService user2ClientRpService;

    public ClientServiceImpl(ClientRpService clientRpService, UserRpService userRpService, UserToClientRpService user2ClientRpService) {
        this.clientRpService = clientRpService;
        this.userRpService = userRpService;
        this.user2ClientRpService = user2ClientRpService;
    }

    /**
     * 创建客户
     *
     * @param param 创建客户的请求参数,包括创建当前客户的用户ID,以及客户名称
     */
    @Override
    public void createClient(CreateClientParam param) {

        // 用户有效性检查
        boolean available = userRpService.isAvailable(param.getBelongUserId());
        Assert.state(available, "无效用户,无法创建客户");

        // 构建并保存客户
        buildAndSaveClient(param);
    }

    /**
     * 绑定用户到客户,仅允许操作人是客户的创建人时执行此业务逻辑
     *
     * @param param 执行绑定的参数,包括待绑定的用户,客户 以及 操作人
     */
    @Override
    public void bindUserToClient(BindUserToClientParam param) {

        // 首先检查待绑定的用户和客户是否存在
        User userToBind = userRpService.getById(param.getUserId());
        Assert.notNull(userToBind, "待绑定的用户不存在");

        Client clientToBind = clientRpService.getById(param.getClientId());
        Assert.notNull(clientToBind, "待绑定的客户不存在");

        // 仅在操作人和客户的所属用户是一致的情况下,执行绑定操作
        boolean canBind = clientToBind.getBelongUserId().equals(param.getOperator());
        Assert.state(canBind, "仅允许客户管理员执行绑定");

        // 构建并保存用户的客户的关联关系
        buildUserToClientRelationAndSave(param);
    }

    /**
     * 解除用户的客户的绑定,仅允许操作人是客户的归属人时执行此逻辑
     *
     * @param relationId 关联关系ID
     * @param operator   操作人
     */
    @Override
    public void unBindUserFromClient(Long relationId, Long operator) {

        // 首先检查关联关系是否存在,不存在,则认为解除成功
        UserToClient user2Client = user2ClientRpService.getById(relationId);
        if (user2Client == null) {
            return;
        }

        // 仅允许操作人是客户的归属人的情况下,做解除操作
        Client unBindClient = clientRpService.getById(user2Client.getClientId());
        if (unBindClient == null) {
            return;
        }
        boolean canUnBind = unBindClient.getBelongUserId().equals(operator);
        Assert.state(canUnBind, "仅允许客户管理员执行解绑");

        // 执行解绑
        user2ClientRpService.removeById(relationId);
    }

    /**
     * 分页查询客户绑定的用户列表
     *
     * @param param 客户ID,用户别名,以及分页信息
     * @return 绑定到指定客户的用户列表
     */
    @Override
    public Page<UserToClient> queryUserBind(QueryUserToClientParam param) {
        return user2ClientRpService.queryOnePage(param);
    }


    /**
     * 构建并保存客户
     *
     * @param param 创建客户请求参数
     */
    private void buildAndSaveClient(CreateClientParam param) {
        Client client = new Client();
        client.setClientName(param.getClientName());
        client.setBelongUserId(param.getBelongUserId());
        client.setStatus(ClientStatusEnum.AVAILABLE);
        clientRpService.save(client);
    }

    /**
     * 构建用户和客户的绑定关系,并保存
     *
     * @param param 执行保定需要的参数
     */
    private void buildUserToClientRelationAndSave(BindUserToClientParam param) {
        UserToClient user2Client = new UserToClient();
        user2Client.setClientId(param.getClientId());
        user2Client.setUserId(param.getUserId());
        user2Client.setUserAlias(param.getUserAlias());
        try {
            user2ClientRpService.save(user2Client);
        } catch (DuplicateKeyException e) {
            log.warn("用户和客户的关联关系已经存在,无需处理", e);
        }
    }

}
