package com.catface.eden.service.user;

import com.catface.eden.service.user.model.UserDetailModel;

/**
 * @author catface
 * @since 2022/8/11
 */
public interface UserService {

    /**
     * 根据用户ID查询用户
     * @param userId 用户ID
     * @return 用户详情
     */
    UserDetailModel queryUserDetail(Long userId);
}
