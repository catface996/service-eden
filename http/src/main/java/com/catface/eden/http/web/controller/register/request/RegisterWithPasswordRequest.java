package com.catface.eden.http.web.controller.register.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author catface
 * @since 2022/8/11
 */
@ApiModel(description = "通过用账号密码注册请求")
@Data
public class RegisterWithPasswordRequest {

    @ApiModelProperty(value = "待注册的账号",required = true,example = "abcdef")
    @NotBlank(message = "待注册的账号不能为空")
    private String account;

    @ApiModelProperty(value = "账号密码",required = true,example = "131212")
    @NotBlank(message = "登录密码不能为空")
    private String password;

}
