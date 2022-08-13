package com.catface.eden.api.auth;

import com.catface.common.model.JsonResult;
import com.catface.eden.api.auth.request.CheckTokenRequest;
import com.catface.eden.api.auth.vo.TokenInfoVO;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author catface
 * @since 2022/8/13
 */
@Slf4j
@Component
public class AuthApiFallback implements FallbackFactory<AuthApi> {

    @Override
    public AuthApi create(Throwable cause) {
        return new AuthApi() {
            /**
             * 校验token接口
             *
             * @param request jwt token
             * @return token中的当前登录用户ID和客户ID
             */
            @Override
            public JsonResult<TokenInfoVO> checkToken(CheckTokenRequest request) {
                log.error("远程调用校验token接口异常", cause);
                return JsonResult.rpcError("远程调用校验token接口异常");
            }
        };
    }
}
