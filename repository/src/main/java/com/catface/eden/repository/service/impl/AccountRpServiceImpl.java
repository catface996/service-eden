package com.catface.eden.repository.service.impl;

import com.catface.eden.repository.entity.Account;
import com.catface.eden.repository.mapper.AccountMapper;
import com.catface.eden.repository.service.AccountRpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账号 服务实现类
 * </p>
 *
 * @author catface
 * @since 2022-08-11
 */
@Service
public class AccountRpServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountRpService {


    /**
     * 根据账号查询
     *
     * @param account 待查询的登录账号
     * @return 匹配的登录账号
     */
    @Override
    public Account queryByAccount(String account) {
        return baseMapper.selectByAccount(account);
    }

}
