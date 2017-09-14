package com.valentichu.server.core.value;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 统计消费类型的VO
 *
 * @author Valentichu
 * created on 2017/09/12
 */
public class StatisticsConsumeType implements Serializable {
    private static final long serialVersionUID = -4422486187544928991L;

    private Integer itemType;
    private BigDecimal total;

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
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
