package com.catface.eden.service.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author catface
 * @since 2022/8/11
 */
@ApiModel(description = "用户详情模型")
@Data
public class UserDetailModel {

    @ApiModelProperty(value = "用户ID")
    private Long userId;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "用户头像")
    private String avatar;

    @ApiModelProperty(value = "用户关联的客户")
    private List<ClientModel> clients;
}
