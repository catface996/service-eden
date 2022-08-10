package com.catface.eden.http.web.controller.auth.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author catface
 * @date 2022/8/10
 */
@ApiModel(description = "密码登录请求模型")
@Data
public class LoginWithPasswordRequest {

    @ApiModelProperty(value = "登录账号",required = true,example = "17767675656")
    @NotBlank(message = "登录账号不能为空")
    private String account;

    @ApiModelProperty(value = "登录密码",required = true,example = "1234321")
    @NotBlank(message = "登录密码不能为空")
    private String password;

}
