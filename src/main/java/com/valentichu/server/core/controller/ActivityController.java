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

    @RequestMapping(value = "/{activityId}", method = RequestMethod.GET)
    @ApiOperation(value = "查询活动细节", notes = "查询活动细节 ")
    public Result getActivityDetail(@PathVariable("activityId") @ApiParam("活动Id") int activityId) {
        ActivityDetail activityDetailList = activityService.getActivityDetail(activityId);
        return ResultGenerator.genSuccessResult(activityDetailList);
    }

    @RequestMapping(value = "/{activityId}/user/{userId}/item", method = RequestMethod.GET)
    @ApiOperation(value = "列出用户的账目", notes = "列出用户的账目")
    public Result listItemByUser(@PathVariable("userId") @ApiParam("用户Id") int userId) {
        List<SettlementDetail> settlementDetailList = activityService.listItemOverviewByUser(userId);
        return ResultGenerator.genSuccessResult(settlementDetailList);
    }

    @RequestMapping(value = "/{activityId}/item/{itemId}", method = RequestMethod.PUT)
    @ApiOperation(value = "更新用户的账目", notes = "更新用户的账目")
    public Result updateItem(@RequestBody @ApiParam("活动账目") Item item) {
        activityService.updateItem(item);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/{activityId}/item", method = RequestMethod.POST)
    @ApiOperation(value = "新增活动账目", notes = "新增活动账目 ")
    public Result addItem(@RequestBody @ApiParam("活动账目") Item item) throws ServiceException {
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

    @RequestMapping(value = "/{activityId}", method = RequestMethod.PUT)
    @ApiOperation(value = "更新活动", notes = "更新活动")
    public Result updateActivity(@RequestBody @ApiParam("要更新的活动") ActivityEdit activityEdit) {
        activityService.updateActivity(activityEdit);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/{activityId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除活动", notes = "删除活动")
    public Result deleteActivity(@PathVariable("activityId") @ApiParam("活动Id") int activityId) {
        activityService.deleteActivity(activityId);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/{activityId}/item/{itemId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除账目", notes = "删除账目")
    public Result deleteItem(@PathVariable("itemId") @ApiParam("账目Id") int itemId) {
        activityService.deleteItem(itemId);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping(value = "/{activityId}/item/{itemId}", method = RequestMethod.GET)
    @ApiOperation(value = "列出账目展示信息", notes = "列出账目展示信息")
    public Result listItemView(@PathVariable("activityId") @ApiParam("活动Id") int activityId,
                               @PathVariable("itemId") @ApiParam("账目Id") int itemId,
                               HttpServletRequest request) {
        String openId = requestUtils.getUserIdFromHeader(request);
        List<ItemView> itemViewList = activityService.listItemView(activityId, itemId, openId);
        return ResultGenerator.genSuccessResult(itemViewList);
    }
}
