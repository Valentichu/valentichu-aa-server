package com.valentichu.server.core.mapper;

import com.valentichu.server.core.domain.Activity;
import com.valentichu.server.core.domain.ActivityUser;
import com.valentichu.server.core.domain.Item;
import com.valentichu.server.core.domain.ItemDetail;
import com.valentichu.server.core.value.*;

import java.util.List;

/**
 * 活动相关数据库接口
 *
 * @author Valentichu
 * created on 2017/08/25
 */
public interface ActivityMapper {
    /**
     * 向数据库保存活动
     *
     * @param activity 活动名称
     * @return 插入的条数
     */
    int saveActivity(Activity activity);

    /**
     * 向数据库中的活动关联用户
     *
     * @param activityUser 活动用户
     * @return 插入的条数
     */
    int bindUser(ActivityUser activityUser);

    /**
     *取得活动关联用户
     *
     * @param activityId 活动Id
     * @return 插入的条数
     */
    List<ActivityUser> getUser(int activityId);

    /**
     * 向数据库保存活动账目
     *
     * @param item 活动账目
     * @return 插入的条数
     */
    int saveItem(Item item);

    /**
     * 向数据库中的活动账目关联细项
     *
     * @param itemDetail 账目细项
     * @return 插入的条数
     */
    int bindItemDetail(ItemDetail itemDetail);

    /**
     * 查询某活动的统计明细
     *
     * @param activityId 活动id
     * @return 统计明细
     */
    List<StatisticsDetail> listStatisticsDetail(int activityId);

    /**
     * 查询某活动的统计结算
     *
     * @param activityId 活动id
     * @return 统计结算
     */
    List<StatisticsSettlement> listStatisticsSettlement(int activityId);

    /**
     * 查询某活动的按消费分类的统计价格
     *
     * @param activityId 活动id
     * @return 各消费类型的价格总计
     */
    List<StatisticsConsumeType> listStatisticsConsumeType(int activityId);

    /**
     * 查询某用户的所有活动的概览
     *
     * @param openId 用户的openId
     * @return 活动的概览列表
     */
    List<ActivityOverview> listActivityOverview(String openId);
}
