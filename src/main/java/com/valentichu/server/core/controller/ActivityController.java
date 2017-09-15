package com.valentichu.server.core.controller;

import com.valentichu.server.base.exception.ServiceException;
import com.valentichu.server.common.value.Result;
import com.valentichu.server.common.value.ResultGenerator;
import com.valentichu.server.core.domain.Item;
import com.valentichu.server.core.service.ActivityService;
import com.valentichu.server.core.util.RequestUtils;
import com.valentichu.server.core.value.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户相关API控制器
 *
 * @author Valentichu
 * created on 2017/09/12
 */
@RestController
@Api(value = "活动相关的API", description = "活动相关的API")
@RequestMapping(value = "/activity")
public class ActivityController {
    private final ActivityService activityService;
    private final RequestUtils requestUtils;

    @Autowired
    public ActivityController(ActivityService activityService, RequestUtils requestUtils) {
        this.activityService = activityService;
        this.requestUtils = requestUtils;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ApiOperation(value = "新增活动", notes = "新增活动 ")
    public Result addActivity(@RequestBody @ApiParam("新增活动的详情") ActivityDetail activityDetail,
                              HttpServletRequest request) throws ServiceException {
        String openId = requestUtils.getUserIdFromHeader(request);
        int activityId = activityService.saveActivity(openId, activityDetail);
        return ResultGenerator.genSuccessResult(activityId);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "列出活动", notes = "列出活动 ")
    public Result listActivity(HttpServletRequest request) {
        String openId = requestUtils.getUserIdFromHeader(request);
        List<ActivityOverview> activityOverviewList = activityService.listActivityOverview(openId);
        return ResultGenerator.genSuccessResult(activityOverviewList);
    }

    @RequestMapping(value = "/{activityId}/user", method = RequestMethod.GET)
    @ApiOperation(value = "列出活动的用户", notes = "列出活动的用户 ")
    public Result listUser(@PathVariable("activityId") @ApiParam("活动Id") int activityId,
                           HttpServletRequest request) {
        String openId = requestUtils.getUserIdFromHeader(request);
        List<UserDetail> userDetailList = activityService.getUsers(openId, activityId);
        return ResultGenerator.genSuccessResult(userDetailList);
    }

    @RequestMapping(value = "/{activityId}/user/{userId}/item", method = RequestMethod.GET)
    @ApiOperation(value = "列出用户的账目", notes = "列出用户的账目")
    public Result listItemByUser(@PathVariable("userId") @ApiParam("用户Id") int userId) {
        List<SettlementDetail> settlementDetailList = activityService.listItemOverviewByUser(userId);
        return ResultGenerator.genSuccessResult(settlementDetailList);
    }

    @RequestMapping(value = "/{activityId}/item", method = RequestMethod.POST)
    @ApiOperation(value = "新增活动账目", notes = "新增活动账目 ")
    public Result addItem(@RequestBody @ApiParam("活动账目") Item item) throws ServiceException {
        System.out.println(item);
        int itemId = activityService.saveItem(item);
        return ResultGenerator.genSuccessResult(itemId);
    }

    @RequestMapping(value = "/{activityId}/statistics", method = RequestMethod.GET)
    @ApiOperation(value = "查询活动的统计", notes = "查询活动的统计 ")
    public Result getStatisticIndex(@PathVariable("activityId") @ApiParam("活动Id") int activityId,
                                    HttpServletRequest request) {
        StatisticsIndex statisticsIndex = activityService.getStatisticsIndex(activityId);
        return ResultGenerator.genSuccessResult(statisticsIndex);
    }
}
