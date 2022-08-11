package com.catface.eden.http.web.controller.client.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author catface
 * @since 2022/8/11
 */
@Data
public class CreateClientRequest {

    @ApiModelProperty(value = "当前登录的客户ID", required = true, example = "121212")
    @NotNull(message = "当前登录的用户ID不能为空")
    public Long ctxUserId;

    @ApiModelProperty(value = "客户名称", required = true, example = "大猫科技")
    @NotBlank(message = "客户名称不能为空")
    public String clientName;

}
