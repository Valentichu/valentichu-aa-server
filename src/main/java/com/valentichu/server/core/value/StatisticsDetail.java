package com.valentichu.server.core.value;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * 统计明细的VO
 *
 * @author Valentichu
 * created on 2017/09/12
 */
public class StatisticsDetail implements Serializable {
    private static final long serialVersionUID = 5716447485019359515L;

    private String itemDescription;
    @JSONField(format = "yyyy-MM-dd")
    private Date createdDate;
    private BigDecimal itemTotal;
    private Integer itemId;
    private Integer itemType;
    private Integer fundOrConsume;
    private String userName;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
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

    public BigDecimal getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(BigDecimal itemTotal) {
        this.itemTotal = itemTotal;
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public Integer getFundOrConsume() {
        return fundOrConsume;
    }

    public void setFundOrConsume(Integer fundOrConsume) {
        this.fundOrConsume = fundOrConsume;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
