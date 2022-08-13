package com.catface.eden.http.web.controller.auth.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author catface
 * @since 2022/8/13
 */
@ApiModel(description = "切换当前的客户请求")
@Data
public class SwitchClientRequest {

    @ApiModelProperty(value = "当前登录的用户ID", required = true, example = "1234567890")
    @NotNull(message = "当前登录的用户ID不能为空")
    private Long ctxUserId;

    @ApiModelProperty(value = "待切换的目标客户ID", required = true, example = "987654321")
    @NotNull(message = "待切换的目标客户不能为空")
    private Long targetClientId;
}
