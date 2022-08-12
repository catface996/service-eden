package com.catface.eden.http.web.controller.client.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author catface
 * @since 2022/8/12
 */
@Data
@ApiModel(description = "添加用户到客户请求")
public class BindUserToClientRequest {

    @ApiModelProperty(value = "当前登录的用户ID",required = true,example = "1234567890")
    @NotNull(message = "当前登录用户的ID不能为空")
    private Long ctxUserId;

    @ApiModelProperty(value = "待关联的客户ID",required = true,example = "12333847")
    @NotNull(message = "待关联的客户ID不能为空")
    private Long ctxClient;

    @ApiModelProperty(value = "待关联的用户ID",required = true,example = "987654321")
    @NotNull(message = "待关联的用户ID不能为空")
    private Long bindUserId;

    @ApiModelProperty(value = "待关联的用户别名",required = true,example = "大脸猫")
    @NotNull(message = "待关联的用户别名不能为空")
    private String bindUserAlias;

}
