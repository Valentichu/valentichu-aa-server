package com.valentichu.server.core.mapper;

import com.valentichu.server.core.domain.User;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;

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
     * @param activityName 活动名称
     * @param createdDate  创建时间
     * @param openId       用户openId
     * @return 活动主键
     */
    Integer saveActivity(@Param("activityName") String activityName,
                         @Param("createdDate") Date createdDate,
                         @Param("openId") String openId);

    //TODO 改为一对多直接存对象

    /**
     * 向数据库中的活动关联用户
     *
     * @param activityId 活动Id
     * @param userName   用户名称
     * @param userWeight 用户权重
     * @param openId     用户openId,可以为空
     * @return 用户主键
     */
    Integer bindUser(@Param("activityId") Integer activityId,
                     @Param("userName") String userName,
                     @Param("userWeight") Integer userWeight,
                     @Param("openId") String openId);
}
