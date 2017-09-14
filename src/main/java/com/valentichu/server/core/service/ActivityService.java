package com.valentichu.server.core.service;

import com.valentichu.server.base.exception.ServiceException;
import com.valentichu.server.core.domain.Item;
import com.valentichu.server.core.value.ActivityDetail;
import com.valentichu.server.core.value.ActivityOverview;
import com.valentichu.server.core.value.StatisticsIndex;
import com.valentichu.server.core.value.UserDetail;

import java.text.ParseException;
import java.util.List;

/**
 * 活动Service的定义
 *
 * @author Valentichu
 * created on 2017/09/12
 */
public interface ActivityService {
    /**
     * 新建一个活动
     *
     * @param openId 用户的openId
     * @param activityDetail 活动的细节
     * @return 新增的活动Id
     */
    int saveActivity(String openId, ActivityDetail activityDetail) throws ServiceException;

    /**
     * 列出用户信息
     *
     * @param activityId 活动的openId
     * @return 用户信息列表
     */
    List<UserDetail> getUsers(Integer activityId);

    /**
     * 新建活动账目
     *
     * @param item 活动的账目
     * @return 新增的账目Id
     */
    int saveItem(Item item) throws ServiceException;

    /**
     * 新建活动账目
     *
     * @param activityId 活动Id
     * @return 供前端首页展示的统计信息
     */
    StatisticsIndex getStatisticsIndex(int activityId);

    /**
     * 列出活动概率
     *
     * @param openId 用户的openId
     * @return 活动概览列表
     */
    List<ActivityOverview> listActivityOverview(String openId);
}
