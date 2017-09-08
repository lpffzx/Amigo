package com.rabbit.first.controller.test;

import com.rabbit.first.common.constant.UTF8MediaType;
import com.rabbit.first.common.exception.CommonException;
import com.rabbit.first.common.result.CommonResult;
import com.rabbit.first.controller.Base4ClientController;
import com.rabbit.first.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;


@RestController
@RequestMapping("test")
public class TestController extends Base4ClientController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = UTF8MediaType.JSON)
    public CommonResult createFamily(@Context HttpServletRequest request) throws CommonException {
        CommonResult result = CommonResult.success(testService.get());
        return result;
    }
}
