package com.catface.eden.service.client.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author catface
 * @since 2022/8/12
 */
@Data
public class BindUserToClientParam {

    @ApiModelProperty(value = "待绑定到客户的用户ID")
    private Long userId;

    @ApiModelProperty(value = "待绑定到客户的用户别名")
    private String userAlias;

    @ApiModelProperty(value = "待绑定的目标客户ID")
    private Long clientId;

    @ApiModelProperty(value = "执行绑定动作的操作人")
    private Long operator;
}
