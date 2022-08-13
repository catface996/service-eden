package com.catface.eden.service.account;

/**
 * @author catface
 * @since 2022/8/11
 */
public interface AccountService {

    /**
     * 检查账号是否存在
     *
     * @param account 待检查的账号
     * @return true:存在;false:不存在
     */
    boolean exist(String account);

    /**
     * 创建登录账号
     *
     * @param account  登录账号
     * @param password 登录密码
     * @param userName 用户名
     */
    void createAccount(String account, String password,String userName);

    /**
     * 检查登录账号与密码是否匹配,仅针对有效的账号
     *
     * @param account  登录账号
     * @param password 登录密码
     * @return 检查通过, 返回登录账号对应的userId
     */
    Long checkPassword(String account, String password);

    /**
     * 修改登录密码
     *
     * @param accountId   登录账号ID
     * @param oldPassword 原密码
     * @param newPassword 新密码
     */
    void changePassword(Long accountId, String oldPassword, String newPassword);
}
