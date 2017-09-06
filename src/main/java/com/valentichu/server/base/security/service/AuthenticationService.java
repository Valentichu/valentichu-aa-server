package com.valentichu.server.base.security.service;

import com.valentichu.server.base.exception.ServiceException;

/**
 * 鉴权Service的定义
 *
 * @author Valentichu
 * created on 2017/08/25
 */
public interface AuthenticationService {

    /**
     * 登录
     *
     * @param code
     * @return 返回用户token
     * @throws ServiceException 验证失败时抛出
     */
    String login(String code) throws ServiceException;

    /**
     * 刷新
     *
     * @param oldToken 原有Token
     * @return 返回刷新后的Token
     * @throws ServiceException 原有Token无效时抛出
     */
    String refresh(String oldToken) throws ServiceException;
}
