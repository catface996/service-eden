package com.catface.eden.service.user.impl;

import com.catface.eden.service.user.UserService;
import com.catface.eden.service.user.model.ClientModel;
import com.catface.eden.service.user.model.UserDetailModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author catface
 * @since 2022/8/11
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {


    /**
     * 根据登录账户ID查询用户详情
     *
     * @param accountId 登录账户ID
     * @return 用户详情
     */
    @Override
    public UserDetailModel queryByAccount(Long accountId) {
        UserDetailModel model=  new UserDetailModel();
        model.setUserId(13212121212L);
        model.setUserName("catface");

        ClientModel clientModel= new ClientModel();
        clientModel.setClientName("大猫科技");
        clientModel.setClientId(12121212L);
        List<ClientModel> clientModels = new ArrayList<>();
        clientModels.add(clientModel);
        model.setClients(clientModels);
        return model;
    }
}
