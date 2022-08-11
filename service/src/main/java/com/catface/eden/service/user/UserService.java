package com.catface.eden.service.user;

import com.catface.eden.service.user.model.UserDetailModel;

/**
 * @author catface
 * @since 2022/8/11
 */
public interface UserService {

    /**
     * 根据登录账户ID查询用户详情
     * @param accountId 登录账户ID
     * @return 用户详情
     */
    UserDetailModel queryByAccount(Long accountId);
}
