package com.valentichu.server.core.service.impl;

import com.valentichu.server.base.exception.ServiceException;
import com.valentichu.server.core.domain.Activity;
import com.valentichu.server.core.domain.ActivityUser;
import com.valentichu.server.core.mapper.ActivityMapper;
import com.valentichu.server.core.service.ActivityService;
import com.valentichu.server.core.value.ActivityDetail;
import com.valentichu.server.core.value.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Transactional
    @Override
    public int saveActivity(String openId, ActivityDetail activityDetail) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = format.parse(activityDetail.getCreatedDate());
        java.sql.Date createdDate = new java.sql.Date(parsed.getTime());
        Activity activity = new Activity();
        activity.setActivityName(activityDetail.getActivityName());
        activity.setOpenId(openId);
        activity.setCreatedDate(createdDate);
        int count = activityMapper.saveActivity(activity);
        if (count == 0) {
            throw new ServiceException("插入数据库失败");
        }
        for (UserDetail userDetail : activityDetail.getUserDetailList()) {
            ActivityUser activityUser = new ActivityUser();
            if (userDetail.getBindOpenId()) {
                activityUser.setOpenId(openId);

            }
            activityUser.setActivityId(activity.getActivityId());
            activityUser.setUserName(userDetail.getUserName());
            activityUser.setUserWeight(userDetail.getUserWeight());
            activityMapper.bindUser(activityUser);
        }
        return activity.getActivityId();
    }

    @Override
    public List<UserDetail> getUsers(Integer activityId) {
        List<ActivityUser> activityUserList = activityMapper.getUser(activityId);
        List<UserDetail> userDetailList = new ArrayList<>();
        for (ActivityUser activityUser : activityUserList) {
            UserDetail userDetail = new UserDetail();
            userDetail.setUserId(activityUser.getUserId());
            userDetail.setUserName(activityUser.getUserName());
            userDetail.setUserWeight(activityUser.getUserWeight());
            userDetailList.add(userDetail);
        }
        return userDetailList;
    }
}
