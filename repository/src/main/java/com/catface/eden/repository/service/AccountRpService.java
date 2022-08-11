package com.catface.eden.repository.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.catface.eden.repository.entity.Account;

/**
 * <p>
 * 账号 服务类
 * </p>
 *
 * @author catface
 * @since 2022-08-11
 */
public interface AccountRpService extends IService<Account> {

    /**
     * 根据账号查询
     *
     * @param account 待查询的登录账号
     * @return 匹配的登录账号
     */
    Account queryByAccount(String account);
    
}
