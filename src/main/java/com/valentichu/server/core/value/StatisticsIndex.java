package com.valentichu.server.core.value;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.List;


/**
 * 前端首页的统计展示VO
 *
 * @author Valentichu
 * created on 2017/09/12
 */
public class StatisticsIndex implements Serializable {
    private static final long serialVersionUID = 7015425573731521009L;

    private List<StatisticsDetail> statisticsDetailList;
    private List<StatisticsSettlement> statisticsSettlementList;
    private List<StatisticsConsumeType> statisticsConsumeTypeList;

    public List<StatisticsDetail> getStatisticsDetailList() {
        return statisticsDetailList;
    }

    public void setStatisticsDetailList(List<StatisticsDetail> statisticsDetailList) {
        this.statisticsDetailList = statisticsDetailList;
    }

    public List<StatisticsSettlement> getStatisticsSettlementList() {
        return statisticsSettlementList;
    }

    public void setStatisticsSettlementList(List<StatisticsSettlement> statisticsSettlementList) {
        this.statisticsSettlementList = statisticsSettlementList;
    }

    public List<StatisticsConsumeType> getStatisticsConsumeTypeList() {
        return statisticsConsumeTypeList;
    }

    public void setStatisticsConsumeTypeList(List<StatisticsConsumeType> statisticsConsumeTypeList) {
        this.statisticsConsumeTypeList = statisticsConsumeTypeList;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
