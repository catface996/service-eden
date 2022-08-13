package com.catface.eden.service.user.convert;

import com.catface.eden.repository.entity.Client;
import com.catface.eden.repository.entity.User;
import com.catface.eden.service.user.model.ClientModel;
import com.catface.eden.service.user.model.UserDetailModel;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author catface
 * @since 2022/8/13
 */
public class UserConvert {

    private static final BeanCopier USER_ENTITY_TO_MODEL = BeanCopier.create(User.class, UserDetailModel.class, false);

    private static final BeanCopier CLIENT_ENTITY_TO_MODEL = BeanCopier.create(Client.class, ClientModel.class, false);

    private static UserDetailModel convert(User entity) {
        UserDetailModel model = new UserDetailModel();
        USER_ENTITY_TO_MODEL.copy(entity, model, null);
        model.setUserId(entity.getId());
        return model;
    }

    private static ClientModel convert(Client entity) {
        ClientModel model = new ClientModel();
        CLIENT_ENTITY_TO_MODEL.copy(entity, model, null);
        model.setClientId(entity.getId());
        return model;
    }

    private static List<ClientModel> convert(List<Client> entities) {
        List<ClientModel> result = new ArrayList<>(entities.size());
        if (CollectionUtils.isEmpty(entities)) {
            return result;
        }
        for (Client entity : entities) {
            result.add(convert(entity));
        }
        return result;
    }

    public static UserDetailModel convert(User user, List<Client> clients) {
        UserDetailModel detailModel = convert(user);
        List<ClientModel> clientModels = convert(clients);
        detailModel.setClients(clientModels);
        return detailModel;
    }
}
