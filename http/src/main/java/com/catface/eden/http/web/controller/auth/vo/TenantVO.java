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
public class TenantVO {

    @ApiModelProperty(value = "租户ID",required = true,example = "1234567890")
    private Long tenantId;

    @ApiModelProperty(value = "租户名称",required = true,example = "大猫科技")
    private String tenantName;
}
