package com.valentichu.server.core.value;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * 活动的部分信息的VO
 *
 * @author Valentichu
 * created on 2017/09/14
 */
public class ActivityOverview implements Serializable {
    private static final long serialVersionUID = 1740411672207968737L;

    private Integer activityId;
    private String activityName;
    @JSONField(format = "yyyy-MM-dd")
    private Date createdDate;
    private List<Total> totals;

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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<Total> getTotals() {
        return totals;
    }

    public void setTotals(List<Total> totals) {
        this.totals = totals;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
