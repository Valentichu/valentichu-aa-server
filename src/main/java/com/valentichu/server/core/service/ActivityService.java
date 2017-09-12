package com.valentichu.server.core.service;

import com.valentichu.server.core.value.ActivityDetail;

import java.text.ParseException;

/**
 * 活动Service的定义
 *
 * @author Valentichu
 * created on 2017/09/12
 */
public interface ActivityService {
    /**
     * 列出商品
     *
     * @param openId         用户的openId
     * @param activityDetail 活动的细节
     * @return 新增的条数
     */
    Integer saveActivity(String openId, ActivityDetail activityDetail) throws Exception;
}
