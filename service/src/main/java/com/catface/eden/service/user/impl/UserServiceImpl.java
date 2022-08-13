package com.catface.eden.service.user.impl;

import com.catface.eden.repository.entity.Client;
import com.catface.eden.repository.entity.User;
import com.catface.eden.repository.entity.UserToClient;
import com.catface.eden.repository.service.ClientRpService;
import com.catface.eden.repository.service.UserRpService;
import com.catface.eden.repository.service.UserToClientRpService;
import com.catface.eden.service.user.UserService;
import com.catface.eden.service.user.convert.UserConvert;
import com.catface.eden.service.user.model.UserDetailModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author catface
 * @since 2022/8/11
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {


    private final UserRpService userRpService;

    private final ClientRpService clientRpService;

    private UserToClientRpService userToClientRpService;

    public UserServiceImpl(UserRpService userRpService, ClientRpService clientRpService, UserToClientRpService userToClientRpService) {
        this.userRpService = userRpService;
        this.clientRpService = clientRpService;
        this.userToClientRpService = userToClientRpService;
    }

    /**
     * 根据用户ID查询用户
     *
     * @param userId 用户ID
     * @return 用户详情
     */
    @Override
    public UserDetailModel queryUserDetail(Long userId) {

        // 获取用户
        User user = userRpService.getById(userId);
        if (user == null) {
            return null;
        }
        // 获取用户关联的客户
        List<Client> clients = queryClientByUserId(user.getId());

        // 转换成用户详情模型并返回
        return UserConvert.convert(user, clients);
    }

    /**
     * 根据用户ID查询用户关联的客户列表
     *
     * @param userId 用户ID
     * @return 用户关联的客户列表
     */
    private List<Client> queryClientByUserId(Long userId) {
        List<UserToClient> entities = userToClientRpService.queryByUserId(userId);
        if (CollectionUtils.isEmpty(entities)) {
            return new ArrayList<>();
        }
        Set<Long> clientIds = entities.stream().map(UserToClient::getClientId).collect(Collectors.toSet());
        return clientRpService.listByIds(clientIds);
    }

}
