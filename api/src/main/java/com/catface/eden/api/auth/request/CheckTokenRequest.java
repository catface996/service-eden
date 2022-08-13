package com.catface.eden.api.auth.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author catface
 * @since 2022/8/13
 */
@ApiModel(description = "检查token请求")
@Data
public class CheckTokenRequest {

    @ApiModelProperty(value = "待检查的token",required = true,example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJDbGllbnQiLCJjdHhDbGllbnRJZCI6Ijk4NyIsImN0eFVzZXJJZCI6IjEyMyIsImlzcyI6ImNhdGZhY2UiLCJleHAiOjE2NjA0MzAyMDAsImlhdCI6MTY2MDM4NzAwMH0.7lqxJGBCS3w1AvseXdt9eoU6hkcL8WX26fapQ4nj7Zk")
    @NotBlank(message = "token不能为空")
    private String token;

}
