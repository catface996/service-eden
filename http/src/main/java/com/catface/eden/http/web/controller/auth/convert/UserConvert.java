package com.catface.eden.http.web.controller.auth.convert;

import com.catface.eden.http.web.controller.auth.vo.UserVO;
import com.catface.eden.service.user.model.UserDetailModel;
import org.springframework.cglib.beans.BeanCopier;

/**
 * @author catface
 * @since 2022/8/11
 */
public class UserConvert {

    private static final BeanCopier USER_MODEL_2_VO = BeanCopier.create(UserDetailModel.class, UserVO.class, false);

    public static UserVO convert(UserDetailModel model) {
        UserVO vo = new UserVO();
        USER_MODEL_2_VO.copy(model, vo, null);
        return vo;
    }
}
