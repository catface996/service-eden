package com.catface.eden.http.rpc.controller.auth;

import com.catface.common.model.JsonResult;
import com.catface.eden.api.auth.AuthApi;
import com.catface.eden.api.auth.request.CheckTokenRequest;
import com.catface.eden.api.auth.vo.TokenInfoVO;
import com.catface.eden.common.constant.EdenConstant;
import com.catface.eden.http.config.propertis.JwtProperties;
import com.catface.eden.http.config.swagger.SwaggerTagConst;
import com.catface.eden.http.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author catface
 * @since 2022/8/13
 */
@Api(tags = {SwaggerTagConst.AUTH})
@Slf4j
@RestController
public class AuthApiController implements AuthApi {

    private final JwtProperties jwtProperties;

    public AuthApiController(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    /**
     * 校验token接口
     *
     * @param request jwt token
     * @return token中的当前登录用户ID和客户ID
     */
    @ApiOperation(value = "校验token")
    @Override
    public JsonResult<TokenInfoVO> checkToken(CheckTokenRequest request) {
        Map<String, String> map = JwtUtil.verifyJwtToken(request.getToken(), jwtProperties);
        Long ctxClientId = Long.valueOf(map.get(EdenConstant.CTX_CLIENT_ID));
        Long ctxUserId = Long.valueOf(map.get(EdenConstant.CTX_USER_ID));
        TokenInfoVO vo = new TokenInfoVO();
        vo.setCtxClientId(ctxClientId);
        vo.setCtxUserId(ctxUserId);
        return JsonResult.success(vo);
    }
}
