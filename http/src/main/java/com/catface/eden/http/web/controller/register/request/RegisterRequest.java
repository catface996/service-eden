package com.catface.eden.http.web.controller.register.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author catface
 * @date 2022/8/11
 */
@ApiModel(description = "使用验证码注册请求")
@Data
public class RegisterRequest {

    @ApiModelProperty(value = "待注册手机号", required = true, example = "17767675656")
    @NotBlank(message = "待注册手机号不能为空")
    private String mobile;

    @ApiModelProperty(value = "验证码", required = true, example = "123456")
    @NotBlank(message = "验证码不能为空")
    private String verificationCode;

}
