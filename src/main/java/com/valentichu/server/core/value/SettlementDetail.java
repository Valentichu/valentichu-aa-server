package com.valentichu.server.core.value;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * 按人查出的账目概览
 *
 * @author Valentichu
 * created on 2017/09/15
 */
public class SettlementDetail implements Serializable {
    private static final long serialVersionUID = -1693418740396477223L;

    private Integer itemId;
    private String userName;
    private BigDecimal exp;
    private BigDecimal bill;
    private Integer fundOrConsume;
    private String itemDescription;
    @JSONField(format = "yyyy-MM-dd")
    private Date createdDate;
    private Integer itemType;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Integer getFundOrConsume() {
        return fundOrConsume;
    }

    public void setFundOrConsume(Integer fundOrConsume) {
        this.fundOrConsume = fundOrConsume;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
