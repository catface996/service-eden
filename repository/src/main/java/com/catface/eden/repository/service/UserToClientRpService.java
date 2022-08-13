package com.catface.eden.repository.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.catface.eden.repository.entity.UserToClient;
import com.catface.eden.repository.param.QueryUserToClientParam;

import java.util.List;

/**
 * <p>
 * 用户关联客户 服务类
 * </p>
 *
 * @author catface
 * @since 2022-08-12
 */
public interface UserToClientRpService extends IService<UserToClient> {

    /**
     * 分页查询绑定到客户的用户
     *
     * @param param 客户ID,用户别名 以及 分页信息
     * @return 绑定到指定客户的用户列表
     */
    Page<UserToClient> queryOnePage(QueryUserToClientParam param);

    /**
     * 根据用户查询绑定的客户列表
     *
     * @param userId 用户ID
     * @return 用户和客户绑定关系列表
     */
    List<UserToClient> queryByUserId(Long userId);
}
