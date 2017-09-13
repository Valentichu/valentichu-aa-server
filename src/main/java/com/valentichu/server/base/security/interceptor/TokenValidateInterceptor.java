package com.valentichu.server.base.security.interceptor;

import com.valentichu.server.base.exception.ServiceException;
import com.valentichu.server.common.util.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 校验Token的拦截器
 *
 * @author Valentichu
 * created on 2017/08/25
 */
@Component
public class TokenValidateInterceptor extends HandlerInterceptorAdapter {
    @Value("${jwt.header}")
    private String header;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    private final JwtTokenUtils jwtTokenUtils;

    @Autowired
    public TokenValidateInterceptor(JwtTokenUtils jwtTokenUtils) {
        this.jwtTokenUtils = jwtTokenUtils;
    }

    /**
     * 校验Token的拦截方法
     * 校验Header中的Token,如果未通过抛出异常
     * 只要能从Token中读出有效信息即为通过校验
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServiceException {
        final String token = request.getHeader(header);
        if (StringUtils.isEmpty(token) || !token.startsWith(tokenHead)) {
            throw new ServiceException("Token invalid");
        }
        if (jwtTokenUtils.isTokenExpired(token)) {
            throw new ServiceException("Token expired");
        }
        String userId = jwtTokenUtils.getUserIdFromToken(token);
        if (StringUtils.isEmpty(userId)) {
            throw new ServiceException("Token invalid");
        }

        return true;

    }
}