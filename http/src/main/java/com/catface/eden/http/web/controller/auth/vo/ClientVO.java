package com.catface.eden.http.web.controller.auth.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author catface
 * @date 2022/8/10
 */
@Data
@ApiModel(description = "租户模型")
public class ClientVO {

    @ApiModelProperty(value = "客户ID", required = true, example = "8123456789")
    private Long clientId;

    @ApiModelProperty(value = "客户名称", required = true, example = "大猫科技")
    private String clientName;
}
