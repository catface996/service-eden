package com.catface.eden.service.client.impl;

import com.catface.eden.common.enums.ClientStatusEnum;
import com.catface.eden.repository.entity.Client;
import com.catface.eden.repository.service.ClientRpService;
import com.catface.eden.repository.service.UserRpService;
import com.catface.eden.service.client.ClientService;
import com.catface.eden.service.client.param.CreateClientParam;
import lombok.extern.slf4j.Slf4j;
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

    public ClientServiceImpl(ClientRpService clientRpService, UserRpService userRpService) {
        this.clientRpService = clientRpService;
        this.userRpService = userRpService;
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

}
