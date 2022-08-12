package com.catface.eden.repository.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.catface.eden.repository.entity.User;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author catface
 * @since 2022-08-11
 */
public interface UserRpService extends IService<User> {

    /**
     * 判断用户是否有效
     *
     * @param userId 用户ID
     * @return true:有效;false:无效
     */
    boolean isAvailable(Long userId);

}
