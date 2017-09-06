package com.valentichu.server.base.security.service.impl;

import com.alibaba.fastjson.JSON;
import com.valentichu.server.base.exception.ServiceException;

import com.valentichu.server.base.security.service.AuthenticationService;
import com.valentichu.server.base.security.value.SessionKey;
import com.valentichu.server.common.util.JwtTokenUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.sql.Timestamp;

/**
 * 鉴权Service的实现
 *
 * @author Valentichu
 * created on 2017/08/25
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final JwtTokenUtils jwtTokenUtils;
    private final RestTemplate restTemplate;
    private final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);
    @Value("${wx.appId}")
    String appId;
    @Value("${wx.appSecret}")
    String appSecret;

    @Autowired
    public AuthenticationServiceImpl(JwtTokenUtils jwtTokenUtils, RestTemplateBuilder restTemplateBuilder) {
        this.jwtTokenUtils = jwtTokenUtils;
        this.restTemplate = restTemplateBuilder.build();
        ;
    }

    @Override
    public String login(String code) throws ServiceException {
        if (StringUtils.isEmpty(code) || StringUtils.isEmpty(code)) {
            throw new ServiceException("用户code不能为空");
        }

        final String url = "https://api.weixin.qq.com/sns/jscode2session";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("appid", appId)
                .queryParam("secret", appSecret)
                .queryParam("js_code", code)
                .queryParam("grant_type", "authorization_code");
        final String responseString = restTemplate.getForObject(builder.build().encode().toUri(), String.class);
        SessionKey response = JSON.parseObject(responseString, SessionKey.class);
        if (response == null) {
            throw new ServiceException("登录信息有误");
        }

        return jwtTokenUtils.generateToken(response.getOpenId());

    }

    @Override
    public String refresh(String oldToken) throws ServiceException {
        if (StringUtils.isEmpty(oldToken)) {
            throw new ServiceException("Token无效");
        }

        final String refreshedToken = jwtTokenUtils.refreshToken(oldToken);
        if (StringUtils.isEmpty(refreshedToken)) {
            throw new ServiceException("Token已过期或无效");
        }

        return refreshedToken;
    }
}

