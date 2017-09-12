package com.valentichu.server.core.service.impl;

import com.valentichu.server.base.exception.ServiceException;
import com.valentichu.server.core.mapper.ActivityMapper;
import com.valentichu.server.core.mapper.GoodMapper;
import com.valentichu.server.core.service.ActivityService;
import com.valentichu.server.core.value.ActivityDetail;
import com.valentichu.server.core.value.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 活动Service的实现
 *
 * @author Valentichu
 * created on 2017/09/12
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    private final ActivityMapper activityMapper;

    @Autowired
    public ActivityServiceImpl(ActivityMapper activityMapper) {
        this.activityMapper = activityMapper;
    }

    @Override
    public Integer saveActivity(String openId, ActivityDetail activityDetail) throws Exception {
        System.out.println(activityDetail.toString());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = format.parse(activityDetail.getCreatedDate());
        java.sql.Date createdDate = new java.sql.Date(parsed.getTime());
        Integer activityId = activityMapper.saveActivity(activityDetail.getActivityName(), createdDate, openId);
        if (activityId == null) {
            throw new ServiceException("插入数据库失败");
        }
        for (UserDetail userDetail : activityDetail.getUserDetailList()) {
            if (userDetail.getBindOpenId()) {
                activityMapper.bindUser(activityId, userDetail.getUserName(), userDetail.getUserWeight(), openId);
            } else {
                activityMapper.bindUser(activityId, userDetail.getUserName(), userDetail.getUserWeight(), null);
            }
        }
        return null;
    }
}
