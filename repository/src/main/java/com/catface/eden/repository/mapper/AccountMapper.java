package com.catface.eden.repository.mapper;

import com.catface.eden.repository.entity.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 账号 Mapper 接口
 * </p>
 *
 * @author catface
 * @since 2022-08-11
 */
public interface AccountMapper extends BaseMapper<Account> {

    /**
     * 根据账号查询
     * @param account 待查询的登录账号
     * @return 登录账号
     */
    Account selectByAccount(@Param("account") String account);
}
