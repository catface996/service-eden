package com.catface.eden.repository.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catface.eden.common.enums.UserStatusEnum;
import com.catface.eden.repository.entity.User;
import com.catface.eden.repository.mapper.UserMapper;
import com.catface.eden.repository.service.UserRpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author catface
 * @since 2022-08-11
 */
@Slf4j
@Service
public class UserRpServiceImpl extends ServiceImpl<UserMapper, User> implements UserRpService {

    /**
     * 判断用户是否有效
     *
     * @param userId 用户ID
     * @return true:有效;false:无效
     */
    @Override
    public boolean isAvailable(Long userId) {
        User user = getById(userId);
        if (user == null) {
            return false;
        }
        return user.getStatus() == UserStatusEnum.AVAILABLE;
    }
}
