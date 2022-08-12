package com.catface.eden.service.client;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.eden.repository.entity.UserToClient;
import com.catface.eden.service.client.param.BindUserToClientParam;
import com.catface.eden.service.client.param.CreateClientParam;
import com.catface.eden.repository.param.QueryUserToClientParam;

/**
 * @author catface
 * @since 2022/8/11
 */
public interface ClientService {

    /**
     * 创建客户
     *
     * @param param 创建客户的请求参数,包括创建当前客户的用户ID,以及客户名称
     */
    void createClient(CreateClientParam param);

    /**
     * 绑定用户到客户,仅允许操作人是客户的创建人时执行此业务逻辑
     *
     * @param param 执行绑定的参数,包括待绑定的用户,客户 以及 操作人
     */
    void bindUserToClient(BindUserToClientParam param);

    /**
     * 解除用户的客户的绑定,仅允许操作人是客户的归属人时执行此逻辑
     *
     * @param relationId 关联关系ID
     * @param operator   操作人
     */
    void unBindUserFromClient(Long relationId, Long operator);

    /**
     * 分页查询客户绑定的用户列表
     *
     * @param param 客户ID,用户别名,以及分页信息
     * @return 绑定到指定客户的用户列表
     */
    Page<UserToClient> queryUserBind(QueryUserToClientParam param);
}
