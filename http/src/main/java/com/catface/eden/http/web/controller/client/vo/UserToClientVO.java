package com.catface.eden.http.web.controller.client.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author catface
 * @since 2022/8/12
 */
@ApiModel(description = "绑定到客户的用户模型")
@Data
public class UserToClientVO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "用户ID")
    private Long userId;

    @ApiModelProperty(value = "用户别名")
    private String userAlias;

    @ApiModelProperty(value = "创建时间")
    private Date created;

    @ApiModelProperty(value = "备注")
    private String remark;
}
