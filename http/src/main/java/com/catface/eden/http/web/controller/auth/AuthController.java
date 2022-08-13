package com.catface.eden.http.web.controller.auth;

import com.catface.common.model.JsonResult;
import com.catface.eden.common.constant.EdenConstant;
import com.catface.eden.http.config.propertis.JwtProperties;
import com.catface.eden.http.config.swagger.SwaggerTagConst;
import com.catface.eden.http.util.JwtUtil;
import com.catface.eden.http.web.controller.auth.convert.UserConvert;
import com.catface.eden.http.web.controller.auth.request.ChangePasswordRequest;
import com.catface.eden.http.web.controller.auth.request.LoginWithPasswordRequest;
import com.catface.eden.http.web.controller.auth.request.SwitchClientRequest;
import com.catface.eden.http.web.controller.auth.vo.UserVO;
import com.catface.eden.service.account.AccountService;
import com.catface.eden.service.user.UserService;
import com.catface.eden.service.user.model.ClientModel;
import com.catface.eden.service.user.model.UserDetailModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author catface
 * @date 2022/8/10
 */
@Api(tags = {SwaggerTagConst.AUTH})
@Slf4j
@RestController
public class AuthController {

    private final AccountService accountService;

    private final UserService userService;

    private final JwtProperties jwtProperties;

    public AuthController(AccountService accountService, UserService userService, JwtProperties jwtProperties) {
        this.accountService = accountService;
        this.userService = userService;
        this.jwtProperties = jwtProperties;
    }

    @ApiOperation(value = "使用账号密码登录")
    @PostMapping(value = {"/anonymous/auth/loginWithPassword"})
    public JsonResult<UserVO> loginWithPassword(@RequestBody @Valid LoginWithPasswordRequest request) {
        Long userId = accountService.checkPassword(request.getAccount(), request.getPassword());
        UserDetailModel detailModel = userService.queryUserDetail(userId);
        String token = generateToken(detailModel);
        UserVO vo = UserConvert.convert(detailModel, token);
        return JsonResult.success(vo);
    }

    @ApiOperation(value = "切换当前用户操作的客户上下文")
    @PostMapping(value = {"/public/auth/switchClient"})
    public JsonResult<UserVO> switchClient(@RequestBody @Valid SwitchClientRequest request) {
        UserDetailModel detailModel = userService.queryUserDetail(request.getCtxUserId());
        Set<Long> clientIds = detailModel.getClients().stream().map(ClientModel::getClientId).collect(Collectors.toSet());
        Assert.state(clientIds.contains(request.getTargetClientId()), "未被授权操作当前客户");
        String token = generateToken(detailModel, request.getTargetClientId());
        UserVO vo = UserConvert.convert(detailModel, token);
        return JsonResult.success(vo);
    }

    @ApiOperation(value = "修改登录密码")
    @PostMapping(value = {"/public/auth/changePassword"})
    public JsonResult<Boolean> changePassword(@RequestBody @Valid ChangePasswordRequest request) {
        accountService.changePassword(request.getCtxUserId(), request.getOldPassword(), request.getNewPassword());
        return JsonResult.success(true);
    }

    /**
     * 生成token,优先切换到当前用户创建的client,否则选列表中的第一个
     *
     * @param detailModel 当前登录用户的详情模型
     * @return 生成的jwt token
     */
    private String generateToken(UserDetailModel detailModel) {
        ClientModel ctxClient = detailModel.getClients().get(0);
        for (ClientModel client : detailModel.getClients()) {
            if (client.getBelongUserId().equals(detailModel.getUserId())) {
                ctxClient = client;
            }
        }
        Map<String, String> claims = new HashMap<>(2);
        claims.put(EdenConstant.CTX_USER_ID, detailModel.getUserId().toString());
        claims.put(EdenConstant.CTX_CLIENT_ID, ctxClient.getClientId().toString());
        return JwtUtil.createJwtToken(claims, jwtProperties);
    }

    /**
     * 生成token,优先切换到当前用户创建的client,否则选列表中的第一个
     *
     * @param detailModel 当前登录用户的详情模型
     * @return 生成的jwt token
     */
    private String generateToken(UserDetailModel detailModel, Long targetClientId) {
        Map<String, String> claims = new HashMap<>(2);
        claims.put(EdenConstant.CTX_USER_ID, detailModel.getUserId().toString());
        claims.put(EdenConstant.CTX_CLIENT_ID, targetClientId.toString());
        return JwtUtil.createJwtToken(claims, jwtProperties);
    }

}
