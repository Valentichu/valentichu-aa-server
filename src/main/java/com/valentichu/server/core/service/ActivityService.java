package com.valentichu.server.core.service;

import com.valentichu.server.base.exception.ServiceException;
import com.valentichu.server.core.domain.Item;
import com.valentichu.server.core.value.*;

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
     * @param openId 当前用户的openId
     * @param activityId 活动的Id
     * @return 用户信息列表
     */
    List<UserDetail> getUsers(String openId, Integer activityId);

    /**
     * 新建活动账目
     *
     * @param item 活动的账目
     * @return 新增的账目Id
     */
    int saveItem(Item item) throws ServiceException;

    /**
     * 列出统计信息
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

    /**
     * 查询某用户的所有账目的概览
     *
     * @param userId 用户的userId
     * @return 账目的概览列表
     */
    List<SettlementDetail> listItemOverviewByUser(int userId);

    /**
     * 查询某活动的细节
     *
     * @param activityId 活动的activityId
     * @return 活动细节
     */
    ActivityDetail getActivityDetail(int activityId);

    /**
     * 更新某活动
     *
     * @param activityEdit 要更新的活动
     * @return 影响的条数
     */
    void updateActivity(ActivityEdit activityEdit);

    /**
     * 删除某活动
     *
     * @param activityId 活动的activityId
     * @return 影响的条数
     */
    void deleteActivity(int activityId);

    /**
     * 根据账目Id查询账目展示信息
     *
     * @param activityId 活动Id
     * @param itemId     账目Id
     * @return 账目的展示列表
     */
    List<ItemView> listItemView(int activityId, int itemId, String openId);

    /**
     * 删除账目
     *
     * @param itemId 账目Id
     * @return 删除的条数，应为1
     */
    void deleteItem(int itemId);

    /**
     * 更新账目
     *
     * @param item 活动的账目
     */
    void updateItem(Item item);
}
