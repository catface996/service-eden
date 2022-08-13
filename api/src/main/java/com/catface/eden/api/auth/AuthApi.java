package com.catface.eden.api.auth;

import com.catface.common.model.JsonResult;
import com.catface.eden.api.auth.request.CheckTokenRequest;
import com.catface.eden.api.auth.vo.TokenInfoVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * @author catface
 * @since 2022/8/13
 */
@FeignClient(name = "authApi", url = "${rpc.eden.service}", fallbackFactory = AuthApiFallback.class)
public interface AuthApi {

    /**
     * 校验token接口
     *
     * @param request jwt token
     * @return token中的当前登录用户ID和客户ID
     */
    @PostMapping(value = "/private/auth/checkToken")
    JsonResult<TokenInfoVO> checkToken(@RequestBody @Valid CheckTokenRequest request);
}
