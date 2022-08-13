package com.catface.eden.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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


    /**
     * 根据用户查询绑定的客户列表
     *
     * @param userId 用户ID
     * @return 用户和客户的关联关系列表
     */
    List<UserToClient> selectByUserId(@Param("userId") Long userId);
}
