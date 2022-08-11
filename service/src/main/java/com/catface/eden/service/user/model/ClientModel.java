package com.catface.eden.service.user.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author catface
 * @since 2022/8/11
 */
@Data
public class ClientModel {

    @ApiModelProperty(value = "客户ID")
    private Long clientId;

    @ApiModelProperty(value = "客户名称")
    private String clientName;
}
