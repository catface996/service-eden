package com.catface.eden.http.web.controller.register;

import com.catface.common.model.JsonResult;
import com.catface.eden.http.config.swagger.SwaggerTagConst;
import com.catface.eden.http.web.controller.register.request.RegisterRequest;
import com.catface.eden.http.web.controller.register.request.SendVerificationCodeRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author catface
 * @date 2022/8/11
 */
@Api(tags = {SwaggerTagConst.REGISTER})
@Slf4j
@RestController
public class RegisterController {


    @ApiOperation(value = "发送注册短信验证码")
    @PostMapping(value = {"/anonymous/register/sendVerificationCode"})
    public JsonResult<Integer> sendVerificationCode(@RequestBody @Valid SendVerificationCodeRequest request) {
        return JsonResult.success(60);
    }


    @ApiOperation(value = "使用验证码注册")
    @PostMapping(value = {"/anonymous/register/registerWithVerificationCode"})
    public JsonResult<Boolean> registerWithVerificationCode(@RequestBody @Valid RegisterRequest request) {
        return JsonResult.success(true);
    }


}
