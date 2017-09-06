package com.valentichu.server.base.security.controller;

import com.valentichu.server.base.exception.ServiceException;
import com.valentichu.server.common.value.ResultGenerator;
import com.valentichu.server.common.value.Result;
import com.valentichu.server.base.security.service.AuthenticationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 鉴权相关的Controller
 *
 * @author Valentichu
 * created on 2017/08/25
 */
@RestController
@RequestMapping(value = "/auth")
@Api(value = "权限相关的API", description = "权限相关的API")
public class AuthenticationController {
    @Value("${jwt.header}")
    private String header;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Value("${jwt.expiration}")
    private Integer expiration;

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ApiOperation(value = "通过小程序发来的code向微信服务器获取用户唯一标记openid,加密成token返回给客户端",
            notes = "通过小程序发来的code向微信服务器获取用户唯一标记openid,加密成token返回给客户端")
    public Result createAuthenticationToken(@RequestParam @ApiParam("用户的code") String code,
                                            HttpServletResponse response) throws ServiceException {
        final String token = authenticationService.login(code);
        Result result = ResultGenerator.genSuccessResult(token);
        return result;
    }

    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    @ApiOperation(value = "刷新Token", notes = "刷新Token")
    public Result refreshAndGetAuthenticationToken(HttpServletRequest request) throws ServiceException {
        final String oldToken = request.getHeader(header);
        final String refreshedToken = authenticationService.refresh(oldToken);
        return ResultGenerator.genSuccessResult(refreshedToken);
    }
}
