package com.catface.eden.http.web.controller.auth.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author catface
 * @date 2022/8/10
 */
@ApiModel(description = "修改登录密码请求")
@Data
public class ChangePasswordRequest {

    @ApiModelProperty(value = "当前登录用户的ID(网关注入,前端无需传入)", required = true, example = "91234567890")
    @NotNull(message = "当前登录的用户ID不能为空")
    private Long ctxUserId;

    @ApiModelProperty(value = "旧密码", required = true, example = "abcdefg")
    @NotBlank(message = "旧密码不能为空")
    private String oldPassword;


    @ApiModelProperty(value = "新密码", required = true, example = "xyzabc")
    @NotBlank(message = "新密码不能为空")
    private String newPassword;
}
