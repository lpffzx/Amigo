package com.rabbit.first.controller.lifepay.client;

import com.rabbit.first.common.constant.UTF8MediaType;
import com.rabbit.first.common.exception.CommonException;
import com.rabbit.first.common.result.CommonResult;
import com.rabbit.first.controller.Base4ClientController;
import com.rabbit.first.dto.lifepay.params.LifePayUserPDTO;
import com.rabbit.first.service.lifepay.client.LifePayUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;


@RestController
@RequestMapping("lifepay/user")
public class LifePayUser4ClientController extends Base4ClientController {

    @Autowired
    LifePayUserService lpuService;

    @RequestMapping(value = "/createFamily", method = RequestMethod.POST, consumes = UTF8MediaType.JSON, produces = UTF8MediaType.JSON)
    public CommonResult createFamily(@Context UriInfo ui, @Context HttpServletRequest request, LifePayUserPDTO paramsDTO) throws CommonException {
        CommonResult result = CommonResult.success(lpuService.createFamily(paramsDTO));
        return result;
    }


    @RequestMapping(value = "/addFamilyMember", method = RequestMethod.POST, consumes = UTF8MediaType.JSON, produces = UTF8MediaType.JSON)
    public CommonResult addFamilyMember(@Context UriInfo ui, @Context HttpServletRequest request, LifePayUserPDTO paramsDTO) throws CommonException {
        CommonResult result = CommonResult.success(lpuService.addFamilyMember(paramsDTO));
        return result;
    }


    @RequestMapping(value = "/recordPowerUse", method = RequestMethod.POST, consumes = UTF8MediaType.JSON, produces = UTF8MediaType.JSON)
    public CommonResult recordPowerUse(@Context UriInfo ui, @Context HttpServletRequest request, LifePayUserPDTO paramsDTO) throws CommonException {
        CommonResult result = CommonResult.success(lpuService.recordPowerUseSituation(paramsDTO));
        return result;
    }
}
