package com.valentichu.server.core.value;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * 注册活动的VO
 *
 * @author Valentichu
 * created on 2017/09/12
 */
public class ActivityDetail implements Serializable {
    private static final long serialVersionUID = 2115941636644124825L;

    private String activityName;
    @JSONField(format = "yyyy-MM-dd")
    private Date createdDate;
    List<UserDetail> userDetailList;

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<UserDetail> getUserDetailList() {
        return userDetailList;
    }

    public void setUserDetailList(List<UserDetail> userDetailList) {
        this.userDetailList = userDetailList;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
