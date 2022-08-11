package com.catface.eden.service.client.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author catface
 * @since 2022/8/11
 */
@Data
public class CreateClientParam {

    @ApiModelProperty(value = "客户所属用户ID")
    private Long belongUserId;

    @ApiModelProperty(value = "客户名称")
    private String clientName;

}
