package com.catface.eden.http.web.controller.auth.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author catface
 * @date 2022/8/10
 */
@Data
@ApiModel(description = "登录响应结果")
public class LoginVO {

    @ApiModelProperty(value = "当前登录用户ID",required = true,example = "91234567890")
    private Long userId;

    @ApiModelProperty(value = "当前用户所属的租户列表",required = true)
    private List<TenantVO> tenants;

}
