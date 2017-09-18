package com.valentichu.server.core.service.impl;

import com.valentichu.server.base.exception.ServiceException;
import com.valentichu.server.core.domain.Activity;
import com.valentichu.server.core.domain.ActivityUser;
import com.valentichu.server.core.domain.Item;
import com.valentichu.server.core.domain.ItemDetail;
import com.valentichu.server.core.mapper.ActivityMapper;
import com.valentichu.server.core.service.ActivityService;
import com.valentichu.server.core.value.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    public int saveActivity(String openId, ActivityDetail activityDetail) throws ServiceException {
        Activity activity = new Activity();
        activity.setActivityName(activityDetail.getActivityName());
        activity.setOpenId(openId);
        activity.setCreatedDate(activityDetail.getCreatedDate());
        int count = activityMapper.saveActivity(activity);
        if (count == 0) {
            throw new ServiceException("插入数据库失败");
        }
        for (UserDetail userDetail : activityDetail.getUserDetailList()) {
            ActivityUser activityUser = new ActivityUser();
            if (userDetail.getCurrentUser()) {
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
    public List<UserDetail> getUsers(String openId, Integer activityId) {
        List<ActivityUser> activityUserList = activityMapper.getUser(activityId);
        List<UserDetail> userDetailList = new ArrayList<>();
        for (ActivityUser activityUser : activityUserList) {
            UserDetail userDetail = new UserDetail();
            userDetail.setUserId(activityUser.getUserId());
            userDetail.setUserName(activityUser.getUserName());
            userDetail.setUserWeight(activityUser.getUserWeight());
            if (openId.equals(activityUser.getOpenId())) {
                userDetail.setCurrentUser(true);
            }
            userDetailList.add(userDetail);
        }
        return userDetailList;
    }

    @Transactional
    @Override
    public int saveItem(Item item) throws ServiceException {
        int count = activityMapper.saveItem(item);
        if (count == 0) {
            throw new ServiceException("插入数据库失败");
        }
        for (ItemDetail itemDetail : item.getItemDetailList()) {
            itemDetail.setItemId(item.getItemId());
            activityMapper.bindItemDetail(itemDetail);
        }
        return item.getItemId();
    }

    @Override
    public StatisticsIndex getStatisticsIndex(int activityId) {
        List<StatisticsDetail> statisticsDetailList = activityMapper.listStatisticsDetail(activityId);
        List<StatisticsSettlement> statisticsSettlementList = activityMapper.listStatisticsSettlement(activityId);
        List<StatisticsConsumeType> statisticsConsumeTypeList = activityMapper.listStatisticsConsumeType(activityId);
        StatisticsIndex statisticsIndex = new StatisticsIndex();
        statisticsIndex.setStatisticsDetailList(statisticsDetailList);
        statisticsIndex.setStatisticsSettlementList(statisticsSettlementList);
        statisticsIndex.setStatisticsConsumeTypeList(statisticsConsumeTypeList);
        return statisticsIndex;
    }

    @Override
    public List<ActivityOverview> listActivityOverview(String openId) {
        return activityMapper.listActivityOverview(openId);
    }

    @Override
    public List<SettlementDetail> listItemOverviewByUser(int userId) {
        return activityMapper.listItemByUser(userId);
    }

    @Override
    public ActivityDetail getActivityDetail(int activityId) {
        return activityMapper.getActivity(activityId);
    }

    @Transactional
    @Override
    public void updateActivity(ActivityEdit activityEdit) {
        if (activityEdit.getActivityNameEdit()) {
            activityMapper.updateActivityName(activityEdit.getActivityId(), activityEdit.getActivityName());
        }
        for (UserDetail userAdd : activityEdit.getUserAddList()) {
            ActivityUser activityUser = new ActivityUser();
            activityUser.setActivityId(activityEdit.getActivityId());
            activityUser.setUserName(userAdd.getUserName());
            activityUser.setUserWeight(userAdd.getUserWeight());
            activityMapper.bindUser(activityUser);
        }
        for (UserDetail userUpdate : activityEdit.getUserEditList()) {
            activityMapper.updateActivityUser(userUpdate);
        }
    }

    @Transactional
    @Override
    public void deleteActivity(int activityId) {
        activityMapper.deleteActivity(activityId);
        activityMapper.deleteActivityUserByActivityId(activityId);
        activityMapper.deleteItemByActivityId(activityId);
        activityMapper.deleteItemDetailByActivityId(activityId);
    }
}
