package com.catface.eden.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.catface.eden.common.enums.ClientStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 客户
 * </p>
 *
 * @author catface
 * @since 2022-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Client对象", description = "客户")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "客户ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "客户名称")
    private String clientName;

    @ApiModelProperty(value = "所属用户ID")
    private Long belongUserId;

    @ApiModelProperty(value = "客户状态")
    private ClientStatusEnum status;

    @ApiModelProperty(value = "创建时间")
    private Date created;

    @ApiModelProperty(value = "修改时间")
    private Date updated;

    @ApiModelProperty(value = "备注")
    private String remark;


}
