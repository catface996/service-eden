package com.catface.eden.repository.service.impl;

import com.catface.eden.repository.entity.Client;
import com.catface.eden.repository.mapper.ClientMapper;
import com.catface.eden.repository.service.ClientRpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 客户 服务实现类
 * </p>
 *
 * @author catface
 * @since 2022-08-11
 */
@Service
public class ClientRpServiceImpl extends ServiceImpl<ClientMapper, Client> implements ClientRpService {

}
