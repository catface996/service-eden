package com.catface.eden.http.web.controller.client.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author catface
 * @since 2022/8/12
 */
@ApiModel(description = "解除用户和客户关联的请求")
@Data
public class UnBindUserFromClientRequest {

    @ApiModelProperty(value = "当前登录的用户ID", required = true, example = "1234567890")
    @NotNull(message = "当前登录用户的ID不能为空")
    private Long ctxUserId;

    @ApiModelProperty(value = "关联关系ID", required = true, example = "987654321")
    @NotNull(message = "关联关系ID不能为空")
    private Long relationId;
}
