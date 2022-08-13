package com.catface.eden.api.auth.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author catface
 * @since 2022/8/13
 */
@ApiModel(description = "token的解析信息模型")
@Data
public class TokenInfoVO {

    @ApiModelProperty(value = "当前登录的用户ID")
    private Long ctxUserId;

    @ApiModelProperty(value = "当前登录的客户ID")
    private Long ctxClientId;
}
