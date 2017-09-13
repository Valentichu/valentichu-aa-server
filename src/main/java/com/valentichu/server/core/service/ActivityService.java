package com.valentichu.server.core.service;

import com.valentichu.server.core.value.ActivityDetail;
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
     * @return 新增的条数
     */
    int saveActivity(String openId, ActivityDetail activityDetail) throws Exception;

    /**
     * 列出用户信息
     *
     * @param activityId 活动的openId
     * @return 用户信息列表
     */
    List<UserDetail> getUsers(Integer activityId);
}
