package com.catface.eden.http.web.controller.client.convert;

import com.catface.eden.http.web.controller.client.param.CreateClientRequest;
import com.catface.eden.service.client.param.CreateClientParam;
import org.springframework.cglib.beans.BeanCopier;

/**
 * @author catface
 * @since 2022/8/11
 */
public class ClientConvert {

    private static final BeanCopier CREATE_CLIENT_REQUEST_2_PARAM = BeanCopier.create(CreateClientRequest.class, CreateClientParam.class, false);

    public static CreateClientParam convert(CreateClientRequest request) {
        CreateClientParam param = new CreateClientParam();
        CREATE_CLIENT_REQUEST_2_PARAM.copy(request, param, null);
        param.setBelongUserId(request.ctxUserId);
        return param;
    }
}
