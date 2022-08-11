package com.catface.eden.http.web.controller.client;

import com.catface.common.model.JsonResult;
import com.catface.eden.http.config.swagger.SwaggerTagConst;
import com.catface.eden.http.web.controller.client.convert.ClientConvert;
import com.catface.eden.http.web.controller.client.param.CreateClientRequest;
import com.catface.eden.service.client.ClientService;
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
}
