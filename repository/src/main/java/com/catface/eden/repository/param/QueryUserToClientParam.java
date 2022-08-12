package com.catface.eden.repository.param;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.eden.repository.entity.UserToClient;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author catface
 * @since 2022/8/12
 */
@Data
public class QueryUserToClientParam extends Page<UserToClient> {

    @ApiModelProperty(value = "用户别名")
    private String userAlias;

    @ApiModelProperty(value = "客户ID")
    private Long clientId;
}
