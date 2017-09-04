package com.rabbit.first.service.impl.lifepay.client;

import com.rabbit.first.common.exception.CommonException;
import com.rabbit.first.common.result.CommonErrorMessage;
import com.rabbit.first.dao.lifepay.LifePayBillDAO;
import com.rabbit.first.dto.lifepay.LifePayBillDTO;
import com.rabbit.first.dto.lifepay.params.LifePayBillPDTO;
import com.rabbit.first.domain.lifepay.LifePayBillDO;
import com.rabbit.first.service.lifepay.client.LifePayBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LifePayBillServiceImpl implements LifePayBillService {
    @Autowired
    LifePayBillDAO lpbDAO;

    @Override
    public LifePayBillDTO pullBill(LifePayBillPDTO paramsDTO) throws CommonException {
        if (null == paramsDTO) {
            throw new CommonException(CommonErrorMessage.INTERFACE_NO_PARAMS_ERR);
        }
        LifePayBillDO bill = paramsDTO.getBill();
        if (null == bill) {
            throw new CommonException(CommonErrorMessage.INTERFACE_NO_PARAMS_NEEDED_ERR);
        }
        lpbDAO.save(bill);
        LifePayBillDTO result = new LifePayBillDTO();
        result.setLastModifyDate(bill.getLastModifyDate().toString());
        result.setPowerBill(bill.getPowerBill());
        result.setPowerRate(bill.getPowerRate());
        result.setWaterBill(bill.getWaterBill());
        result.setWaterRate(bill.getWaterRate());
        result.setRecordMonth(bill.getRecordMonth());
        return result;
    }
}
