package com.catface.eden.http.web.controller.client.convert;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.common.model.PageVO;
import com.catface.eden.http.web.controller.client.request.BindUserToClientRequest;
import com.catface.eden.http.web.controller.client.request.CreateClientRequest;
import com.catface.eden.http.web.controller.client.request.GetUserByClientRequest;
import com.catface.eden.http.web.controller.client.vo.UserToClientVO;
import com.catface.eden.repository.entity.UserToClient;
import com.catface.eden.repository.param.QueryUserToClientParam;
import com.catface.eden.service.client.param.BindUserToClientParam;
import com.catface.eden.service.client.param.CreateClientParam;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author catface
 * @since 2022/8/11
 */
public class ClientConvert {

    private static final BeanCopier CREATE_CLIENT_REQUEST_2_PARAM = BeanCopier.create(CreateClientRequest.class, CreateClientParam.class, false);

    private static final BeanCopier USER_TO_CLIENT_ENTITY_2_VO = BeanCopier.create(UserToClient.class, UserToClientVO.class, false);

    public static CreateClientParam convert(CreateClientRequest request) {
        CreateClientParam param = new CreateClientParam();
        CREATE_CLIENT_REQUEST_2_PARAM.copy(request, param, null);
        param.setBelongUserId(request.ctxUserId);
        return param;
    }

    public static BindUserToClientParam convert(BindUserToClientRequest request) {
        BindUserToClientParam param = new BindUserToClientParam();
        param.setClientId(request.getCtxClient());
        param.setOperator(request.getCtxUserId());
        param.setUserId(request.getBindUserId());
        param.setUserAlias(request.getBindUserAlias());
        return param;
    }

    public static QueryUserToClientParam convert(GetUserByClientRequest request){
        QueryUserToClientParam param = new QueryUserToClientParam();
        param.setClientId(request.getCtxClientId());
        param.setUserAlias(request.getUserAlias());
        param.setCurrent(request.getCurrent());
        param.setSize(request.getSize());
        return param;
    }

    public static UserToClientVO userToClientConvert(UserToClient entity) {
        if (entity == null) {
            return null;
        }
        UserToClientVO vo = new UserToClientVO();
        USER_TO_CLIENT_ENTITY_2_VO.copy(entity, vo, null);
        return vo;
    }

    public static List<UserToClientVO> userToClientConvert(List<UserToClient> entities) {
        List<UserToClientVO> vos = new ArrayList<>();
        if (CollectionUtils.isEmpty(entities)) {
            return vos;
        }
        for (UserToClient entity : entities) {
            vos.add(userToClientConvert(entity));
        }
        return vos;
    }

    public static PageVO<UserToClientVO> userToClientConvert(Page<UserToClient> page) {
        List<UserToClientVO> vos = userToClientConvert(page.getRecords());
        PageVO<UserToClientVO> pageVO = new PageVO<>(page.getCurrent(), page.getSize(), page.getPages(), page.getTotal());
        pageVO.setRecords(vos);
        return pageVO;
    }

}
