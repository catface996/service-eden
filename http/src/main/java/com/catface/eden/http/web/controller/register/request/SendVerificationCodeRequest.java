package com.catface.eden.http.web.controller.register.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author catface
 * @date 2022/8/11
 */
@ApiModel(description = "发送注册短信")
@Data
public class SendVerificationCodeRequest {

    @ApiModelProperty(value = "待注册手机号码",required = true,example = "17767564545")
    @NotBlank(message = "手机号码不能为空")
    private String mobile;

}
