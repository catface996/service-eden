package com.catface.eden.service.account.impl;

import com.catface.common.exception.CatfaceException;
import com.catface.common.exception.CommonErrorEnum;
import com.catface.eden.common.enums.AccountStatusEnum;
import com.catface.eden.common.enums.UserStatusEnum;
import com.catface.eden.repository.entity.Account;
import com.catface.eden.repository.entity.User;
import com.catface.eden.repository.service.AccountRpService;
import com.catface.eden.repository.service.UserRpService;
import com.catface.eden.service.account.AccountService;
import com.catface.eden.service.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * @author catface
 * @since 2022/8/11
 */
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRpService accountRpService;

    private final UserRpService userRpService;

    public AccountServiceImpl(AccountRpService accountRpService, UserRpService userRpService) {
        this.accountRpService = accountRpService;
        this.userRpService = userRpService;
    }

    /**
     * 检查账号是否存在
     *
     * @param account 待检查的账号
     * @return true:存在;false:不存在
     */
    @Override
    public boolean exist(String account) {
        return accountRpService.queryByAccount(account) != null;
    }

    /**
     * 创建登录账号
     *
     * @param account  登录账号
     * @param password 登录密码
     */
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void createAccount(String account, String password) {

        // 登录账号存在性检查,不允许重复注册
        Account accountExist = accountRpService.queryByAccount(account);
        Assert.state(accountExist == null, "账号已被注册");

        // 创建用户
        User userCreated = createAndSaveUser("未设置");

        // 创建并保存登录账号
        createAndSaveAccount(account, password, userCreated);
    }

    /**
     * 检查登录账号与密码是否匹配,仅针对有效的登录账户
     *
     * @param account  登录账号
     * @param password 登录密码
     * @return 检查通过, 返回登录账号对应的ID
     */
    @Override
    public Long checkPassword(String account, String password) {

        Account accountExist = accountRpService.queryByAccount(account);
        Assert.notNull(accountExist, "登录账号不存在");

        Assert.state(accountExist.getStatus() == AccountStatusEnum.AVAILABLE, "账号不可用");

        String cPwd = MD5Util.md5(password);

        Assert.state(accountExist.getPassword().equals(cPwd), "密码错误");

        return accountExist.getId();
    }

    /**
     * 创建并保存登录账号
     *
     * @param account  待创建的登录账号
     * @param password 登录账号对应的登录密码
     * @param user     账号所属用户
     */
    private void createAndSaveAccount(String account, String password, User user) {
        Account accountForCreate = new Account();
        accountForCreate.setAccount(account);
        accountForCreate.setUserId(user.getId());
        accountForCreate.setPassword(MD5Util.md5(password));
        accountForCreate.setStatus(AccountStatusEnum.AVAILABLE);
        try {
            accountRpService.save(accountForCreate);
        } catch (DuplicateKeyException e) {
            throw new CatfaceException(CommonErrorEnum.DUPLICATE_KEY);
        }
    }

    /**
     * 创建用户
     *
     * @param userName 用户名称
     * @return 保存后的用户
     */
    private User createAndSaveUser(String userName) {
        User userForCreate = new User();
        userForCreate.setUserName(userName);
        userForCreate.setStatus(UserStatusEnum.AVAILABLE);
        userRpService.save(userForCreate);
        return userForCreate;
    }


}
