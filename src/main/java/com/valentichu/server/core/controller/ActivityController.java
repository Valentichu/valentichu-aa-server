package com.valentichu.server.core.controller;

import com.valentichu.server.common.value.Result;
import com.valentichu.server.common.value.ResultGenerator;
import com.valentichu.server.core.service.ActivityService;
import com.valentichu.server.core.service.UserService;
import com.valentichu.server.core.util.RequestUtils;
import com.valentichu.server.core.value.ActivityDetail;
import com.valentichu.server.core.value.UserDetail;
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
    public Result addCart(@RequestBody @ApiParam("新增活动的详情") ActivityDetail activityDetail,
                          HttpServletRequest request) throws Exception {
        String openId = requestUtils.getUserIdFromHeader(request);
        int activityId = activityService.saveActivity(openId, activityDetail);
        return ResultGenerator.genSuccessResult(activityId);
    }

    @RequestMapping(value = "/{activityId}/user", method = RequestMethod.GET)
    @ApiOperation(value = "列出活动的用户", notes = "列出活动的用户 ")
    public Result addCart(@PathVariable("activityId") @ApiParam("活动Id") int activityId,
                          HttpServletRequest request) {
        List<UserDetail> userDetailList = activityService.getUsers(activityId);
        return ResultGenerator.genSuccessResult(userDetailList);
    }
}
