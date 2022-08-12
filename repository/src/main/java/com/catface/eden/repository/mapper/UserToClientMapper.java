package com.catface.eden.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.eden.repository.entity.UserToClient;
import com.catface.eden.repository.param.QueryUserToClientParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户关联客户 Mapper 接口
 * </p>
 *
 * @author catface
 * @since 2022-08-12
 */
public interface UserToClientMapper extends BaseMapper<UserToClient> {

    /**
     * 分页查询绑定到客户的用户列表
     *
     * @param param 客户ID,用户别名 以及 分页信息
     * @return 绑定到客户的用户列表
     */
    List<UserToClient> selectOnePage(@Param("param") QueryUserToClientParam param);
}
