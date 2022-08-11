package com.catface.eden.repository.service.impl;

import com.catface.eden.repository.entity.User;
import com.catface.eden.repository.mapper.UserMapper;
import com.catface.eden.repository.service.UserRpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author catface
 * @since 2022-08-11
 */
@Service
public class UserRpServiceImpl extends ServiceImpl<UserMapper, User> implements UserRpService {

}
