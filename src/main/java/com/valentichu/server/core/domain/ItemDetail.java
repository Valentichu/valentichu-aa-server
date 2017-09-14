package com.valentichu.server.core.domain;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 账目细项DO
 *
 * @author Valentichu
 * created on 2017/09/14
 */
public class ItemDetail implements Serializable {
    private static final long serialVersionUID = -4921821761140488180L;

    private Integer detailId;
    private Integer itemId;
    private Integer userId;
    private Integer activityId;
    private Integer userWeight;
    private String userName;
    private Integer fundOrConsume;
    private BigDecimal exp;
    private BigDecimal bill;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(Integer userWeight) {
        this.userWeight = userWeight;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getFundOrConsume() {
        return fundOrConsume;
    }

    public void setFundOrConsume(Integer fundOrConsume) {
        this.fundOrConsume = fundOrConsume;
    }

    public BigDecimal getExp() {
        return exp;
    }

    public void setExp(BigDecimal exp) {
        this.exp = exp;
    }

    public BigDecimal getBill() {
        return bill;
    }

    public void setBill(BigDecimal bill) {
        this.bill = bill;
    }

    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Timestamp getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
