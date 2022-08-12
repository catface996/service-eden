package com.catface.eden.http.web.controller.client;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.catface.common.model.JsonResult;
import com.catface.common.model.PageVO;
import com.catface.eden.http.config.swagger.SwaggerTagConst;
import com.catface.eden.http.web.controller.client.convert.ClientConvert;
import com.catface.eden.http.web.controller.client.request.BindUserToClientRequest;
import com.catface.eden.http.web.controller.client.request.CreateClientRequest;
import com.catface.eden.http.web.controller.client.request.GetUserByClientRequest;
import com.catface.eden.http.web.controller.client.request.UnBindUserFromClientRequest;
import com.catface.eden.http.web.controller.client.vo.UserToClientVO;
import com.catface.eden.repository.entity.UserToClient;
import com.catface.eden.repository.param.QueryUserToClientParam;
import com.catface.eden.service.client.ClientService;
import com.catface.eden.service.client.param.BindUserToClientParam;
import com.catface.eden.service.client.param.CreateClientParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author catface
 * @date 2022/8/11
 */
@Api(tags = {SwaggerTagConst.CLIENT})
@Slf4j
@RestController
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @ApiOperation(value = "创建客户")
    @PostMapping(value = {"/public/client/create"})
    public JsonResult<Boolean> create(@RequestBody @Valid CreateClientRequest request) {
        CreateClientParam param = ClientConvert.convert(request);
        clientService.createClient(param);
        return JsonResult.success(true);
    }

    @ApiOperation(value = "查询绑定到客户的用户")
    @PostMapping(value = "/public/client/getUsersBindToClient")
    public JsonResult<PageVO<UserToClientVO>> getUsersBindToClient(@RequestBody @Valid GetUserByClientRequest request) {
        QueryUserToClientParam param = ClientConvert.convert(request);
        Page<UserToClient> page = clientService.queryUserBind(param);
        PageVO<UserToClientVO> pageVO = ClientConvert.userToClientConvert(page);
        return JsonResult.success(pageVO);
    }

    @ApiOperation(value = "绑定用户到客户")
    @PostMapping(value = "/public/client/bindUserToClient")
    public JsonResult<Boolean> bindUserToClient(@RequestBody @Valid BindUserToClientRequest request) {
        BindUserToClientParam param = ClientConvert.convert(request);
        clientService.bindUserToClient(param);
        return JsonResult.success(true);
    }

    @ApiOperation(value = "解除用户和客户的绑定")
    @PostMapping(value = "/public/client/unBindUserFromClient")
    public JsonResult<Boolean> unBindUserFromClient(@RequestBody @Valid UnBindUserFromClientRequest request) {
        clientService.unBindUserFromClient(request.getRelationId(), request.getCtxUserId());
        return JsonResult.success(true);
    }
}
