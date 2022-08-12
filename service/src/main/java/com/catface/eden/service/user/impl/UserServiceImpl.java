package com.catface.eden.service.user.impl;

import com.catface.eden.repository.entity.User;
import com.catface.eden.repository.service.ClientRpService;
import com.catface.eden.repository.service.UserRpService;
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


    private final UserRpService userRpService;

    private final ClientRpService clientRpService;

    public UserServiceImpl(UserRpService userRpService, ClientRpService clientRpService) {
        this.userRpService = userRpService;
        this.clientRpService = clientRpService;
    }

    /**
     * 根据用户ID查询用户
     *
     * @param userId 用户ID
     * @return 用户详情
     */
    @Override
    public UserDetailModel queryByUserId(Long userId) {
        User user = userRpService.getById(userId);
        if (user == null){
            return null;
        }

        return null;
    }
}
