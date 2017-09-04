package com.rabbit.first.controller.lifepay.client;

import com.rabbit.first.common.constant.UTF8MediaType;
import com.rabbit.first.common.exception.CommonException;
import com.rabbit.first.common.result.CommonResult;
import com.rabbit.first.controller.Base4ClientController;
import com.rabbit.first.dto.lifepay.params.LifePayBillPDTO;
import com.rabbit.first.service.lifepay.client.LifePayBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;


@RestController
@RequestMapping("lifepay/bill")
public class LifePayBill4ClientController extends Base4ClientController {

    @Autowired
    LifePayBillService lpbService;

    @RequestMapping(value = "/pullBill", method = RequestMethod.POST, consumes = UTF8MediaType.JSON, produces = UTF8MediaType.JSON)
    public CommonResult pullBill(@Context UriInfo ui, @Context HttpServletRequest request, LifePayBillPDTO paramsDTO) throws CommonException {
        CommonResult result = CommonResult.success(lpbService.pullBill(paramsDTO));
        return result;
    }


}
