package com.valentichu.server.core.mapper;

import com.valentichu.server.core.domain.Activity;
import com.valentichu.server.core.domain.ActivityUser;
import com.valentichu.server.core.value.UserDetail;

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
    Integer saveActivity(Activity activity);

    /**
     * 向数据库中的活动关联用户
     *
     * @param activityUser 活动用户
     * @return 插入的条数
     */
    Integer bindUser(ActivityUser activityUser);

    /**
     *取得活动关联用户
     *
     * @param activityId 活动Id
     * @return 插入的条数
     */
    List<ActivityUser> getUser(int activityId);
}
