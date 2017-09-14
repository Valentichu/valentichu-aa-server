package com.valentichu.server.core.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * 账目DO
 *
 * @author Valentichu
 * created on 2017/09/14
 */
public class Item implements Serializable {
    private static final long serialVersionUID = -132457196701001045L;

    private Integer itemId;
    private Integer itemType;
    private String itemDescription;
    private String itemNote;
    private Integer fundOrConsume;
    @JSONField(format = "yyyy-MM-dd")
    private Date createdDate;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private Integer activityId;
    private Integer userId;
    private BigDecimal itemTotal;

    private List<ItemDetail> itemDetailList;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemNote() {
        return itemNote;
    }

    public void setItemNote(String itemNote) {
        this.itemNote = itemNote;
    }

    public Integer getFundOrConsume() {
        return fundOrConsume;
    }

    public void setFundOrConsume(Integer fundOrConsume) {
        this.fundOrConsume = fundOrConsume;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(BigDecimal itemTotal) {
        this.itemTotal = itemTotal;
    }

    public List<ItemDetail> getItemDetailList() {
        return itemDetailList;
    }

    public void setItemDetailList(List<ItemDetail> itemDetailList) {
        this.itemDetailList = itemDetailList;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
