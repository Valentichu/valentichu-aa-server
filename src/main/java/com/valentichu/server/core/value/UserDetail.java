package com.valentichu.server.core.value;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * 注册活动时的用户信息的VO
 *
 * @author Valentichu
 * created on 2017/09/12
 */
public class UserDetail implements Serializable {
    private static final long serialVersionUID = -9198497806215614323L;

    private String userName;
    private Integer userWeight;

    public Boolean getBindOpenId() {
        return bindOpenId;
    }

    public void setBindOpenId(Boolean bindOpenId) {
        this.bindOpenId = bindOpenId;
    }

    private Boolean bindOpenId;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(Integer userWeight) {
        this.userWeight = userWeight;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
