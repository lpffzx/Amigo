package com.rabbit.first.service.lifepay.client;

import com.rabbit.first.common.exception.CommonException;
import com.rabbit.first.dto.lifepay.LifePayBillDTO;
import com.rabbit.first.dto.lifepay.params.LifePayBillPDTO;

public interface LifePayBillService {
    /**
     * 拉取消费账单
     */
    LifePayBillDTO pullBill(LifePayBillPDTO paramsDTO) throws CommonException;



}
