package com.catface.eden.http.web.controller.register.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author catface
 * @since 2022/8/11
 */
@ApiModel(description = "检查账号是否可用于注册的请求")
@Data
public class CheckRegisterAccountRequest {

    @ApiModelProperty(value = "待注册的账号",required = true,example = "abcdefg")
    @NotBlank(message = "待注册的账号不能为空")
    private String account;

}
