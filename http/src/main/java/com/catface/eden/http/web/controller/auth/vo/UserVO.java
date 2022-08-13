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
public class UserVO {

    @ApiModelProperty(value = "用户ID")
    private Long userId;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "用户头像")
    private String avatar;

    @ApiModelProperty(value = "用户关联的客户列表")
    private List<ClientVO> clients;

    @ApiModelProperty(value = "登录凭证")
    private String token;

}
