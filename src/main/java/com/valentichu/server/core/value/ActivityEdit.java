package com.valentichu.server.core.value;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.List;

/**
 * 编辑活动的部分信息的VO
 *
 * @author Valentichu
 * created on 2017/09/18
 */
public class ActivityEdit implements Serializable {
    private static final long serialVersionUID = -515508541046673234L;

    private Integer activityId;
    private String activityName;
    private Boolean activityNameEdit;
    private List<UserDetail> userAddList;
    private List<UserDetail> userEditList;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Boolean getActivityNameEdit() {
        return activityNameEdit;
    }

    public void setActivityNameEdit(Boolean activityNameEdit) {
        this.activityNameEdit = activityNameEdit;
    }

    public List<UserDetail> getUserAddList() {
        return userAddList;
    }

    public void setUserAddList(List<UserDetail> userAddList) {
        this.userAddList = userAddList;
    }

    public List<UserDetail> getUserEditList() {
        return userEditList;
    }

    public void setUserEditList(List<UserDetail> userEditList) {
        this.userEditList = userEditList;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
