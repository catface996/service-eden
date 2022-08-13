package com.catface.eden.http.web.controller.register;

import com.catface.common.model.JsonResult;
import com.catface.eden.http.config.swagger.SwaggerTagConst;
import com.catface.eden.http.web.controller.register.request.CheckRegisterAccountRequest;
import com.catface.eden.http.web.controller.register.request.RegisterRequest;
import com.catface.eden.http.web.controller.register.request.RegisterWithPasswordRequest;
import com.catface.eden.http.web.controller.register.request.SendVerificationCodeRequest;
import com.catface.eden.service.account.AccountService;
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

    private final AccountService accountService;

    public RegisterController(AccountService accountService) {
        this.accountService = accountService;
    }

    @ApiOperation(value = "检查账号是否可用于注册")
    @PostMapping(value = {"/anonymous/register/checkRegisterAccount"})
    public JsonResult<Boolean> checkRegisterAccount(@RequestBody @Valid CheckRegisterAccountRequest request) {
        boolean canRegister = !accountService.exist(request.getAccount());
        return JsonResult.success(canRegister);
    }

    @ApiOperation(value = "通过账号密码注册")
    @PostMapping(value = {"/anonymous/register/registerWithPassword"})
    public JsonResult<Boolean> registerWithPassword(@RequestBody @Valid RegisterWithPasswordRequest request) {
        accountService.createAccount(request.getAccount(), request.getPassword(), request.getUserName());
        return JsonResult.success(true);
    }

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
