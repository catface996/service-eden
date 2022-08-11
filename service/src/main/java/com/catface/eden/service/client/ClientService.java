package com.catface.eden.service.client;

import com.catface.eden.service.client.param.CreateClientParam;

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
}
