package com.valentichu.server.core.value;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 合计消费总额或者交款总额的VO
 *
 * @author Valentichu
 * created on 2017/09/14
 */
public class Total implements Serializable {
    private static final long serialVersionUID = 2120158729156723094L;

    private Integer fundOrConsume;
    private BigDecimal total;

    public Integer getFundOrConsume() {
        return fundOrConsume;
    }

    public void setFundOrConsume(Integer fundOrConsume) {
        this.fundOrConsume = fundOrConsume;
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
