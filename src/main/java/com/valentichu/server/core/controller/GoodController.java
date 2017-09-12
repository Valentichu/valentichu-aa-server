package com.valentichu.server.core.controller;

import com.valentichu.server.common.value.ResultGenerator;
import com.valentichu.server.core.domain.Good;
import com.valentichu.server.core.value.Page;
import com.valentichu.server.common.value.Result;
import com.valentichu.server.core.service.GoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品相关API控制器
 *
 * @author Valentichu
 * created on 2017/08/25
 */
@RestController
@Api(value = "商品相关的API", description = "商品相关的API")
public class GoodController {


}
