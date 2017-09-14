package com.valentichu.server.core.value;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 统计结算的VO
 *
 * @author Valentichu
 * created on 2017/09/12
 */
public class StatisticsSettlement implements Serializable {
    private static final long serialVersionUID = 1150840519395541860L;

    private Integer userId;
    private String userName;
    private BigDecimal total;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
