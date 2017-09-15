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

    private Integer userId;
    private String userName;
    private Integer userWeight;
    private Boolean currentUser = false;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Boolean currentUser) {
        this.currentUser = currentUser;
    }

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
