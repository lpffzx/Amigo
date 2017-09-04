package com.rabbit.first.controller.lifepay.client;

import com.rabbit.first.common.constant.UTF8MediaType;
import com.rabbit.first.common.exception.CommonException;
import com.rabbit.first.common.result.CommonResult;
import com.rabbit.first.controller.Base4ClientController;
import com.rabbit.first.dto.lifepay.params.LifePayRecordPDTO;
import com.rabbit.first.service.lifepay.client.LifePayRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("lifepay/record")
public class LifePayRecord4ClientController extends Base4ClientController {

    @Autowired
    LifePayRecordService lprService;

    @RequestMapping(value = "/generateCostRecord", method = RequestMethod.POST, consumes = UTF8MediaType.JSON, produces = UTF8MediaType.JSON)
    public CommonResult generateCostRecordByRecordMonth(@RequestBody LifePayRecordPDTO paramsDTO) throws CommonException {
        CommonResult result = CommonResult.success(lprService.generateCostRecordByRecordMonth(paramsDTO));
        return result;
    }


    @RequestMapping(value = "/listCostRecord", method = RequestMethod.POST, consumes = UTF8MediaType.JSON, produces = UTF8MediaType.JSON)
    public CommonResult listCostRecordByRecordMonth(@RequestBody LifePayRecordPDTO paramsDTO) throws CommonException {
        CommonResult result = CommonResult.success(lprService.listCostRecordByRecordMonth(paramsDTO));
        return result;
    }

    @RequestMapping(value = "/removeCostRecord", method = RequestMethod.POST, consumes = UTF8MediaType.JSON, produces = UTF8MediaType.JSON)
    public CommonResult removeCostRecord(@RequestBody LifePayRecordPDTO paramsDTO) {
        lprService.removeCostRecord(paramsDTO);
        CommonResult result = CommonResult.success();
        return result;
    }

}
