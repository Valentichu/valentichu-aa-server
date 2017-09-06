package com.valentichu.server.base.security.value;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 从服务器获取的用户登录态信息
 *
 * @author Valentichu
 * created on 2017/09/06
 */
public class SessionKey implements Serializable {
    private static final long serialVersionUID = -8498171357022335386L;
    @JSONField(name = "openid")
    private String openId;
    @JSONField(name = "session-key")
    private String sessionKey;
    @JSONField(name = "unionid")
    private String unionId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
