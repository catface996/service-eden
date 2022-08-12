package com.catface.eden.http.web.controller.client.request;

import com.catface.common.model.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author catface
 * @since 2022/8/12
 */
@ApiModel(description = "根据客户查询绑定的用户")
@Data
public class GetUserByClientRequest extends PageRequest {

    @ApiModelProperty(value = "客户ID", required = true, example = "1234567890")
    @NotNull(message = "客户ID不能为空")
    private Long ctxClientId;

    @ApiModelProperty(value = "客户别名")
    private String userAlias;

}
