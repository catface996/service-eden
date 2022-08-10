package com.catface.eden.http.web.controller.auth;

import com.catface.common.model.JsonResult;
import com.catface.eden.http.config.swagger.SwaggerTagConst;
import com.catface.eden.http.web.controller.auth.request.ChangePasswordRequest;
import com.catface.eden.http.web.controller.auth.request.LoginWithPasswordRequest;
import com.catface.eden.http.web.controller.auth.vo.LoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author catface
 * @date 2022/8/10
 */
@Api(tags = {SwaggerTagConst.AUTH})
@Slf4j
@RestController
public class AuthController {


    @ApiOperation(value = "使用账号密码登录")
    @PostMapping(value = {"/anonymous/auth/loginWithPassword"})
    public JsonResult<LoginVO> loginWithPassword(@RequestBody @Valid LoginWithPasswordRequest request) {
        return JsonResult.success(new LoginVO());
    }

    @ApiOperation(value = "修改登录密码")
    @PostMapping(value = {"/public/auth/changePassword"})
    public JsonResult<Boolean> changePassword(@RequestBody @Valid ChangePasswordRequest request) {
        return JsonResult.success(true);
    }

}
