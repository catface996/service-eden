package com.catface.eden.repository.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.catface.eden.repository.entity.UserToClient;
import com.catface.eden.repository.mapper.UserToClientMapper;
import com.catface.eden.repository.param.QueryUserToClientParam;
import com.catface.eden.repository.service.UserToClientRpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户关联客户 服务实现类
 * </p>
 *
 * @author catface
 * @since 2022-08-12
 */
@Slf4j
@Service
public class UserToClientRpServiceImpl extends ServiceImpl<UserToClientMapper, UserToClient> implements UserToClientRpService {

    /**
     * 分页查询绑定到客户的用户
     *
     * @param param 客户ID,用户别名 以及 分页信息
     * @return 绑定到指定客户的用户列表
     */
    @Override
    public Page<UserToClient> queryOnePage(QueryUserToClientParam param) {
        List<UserToClient> entities = baseMapper.selectOnePage(param);
        return param.setRecords(entities);
    }
}
