package com.rabbit.first.service.impl.lifepay.client;

import com.rabbit.first.common.constant.Constants;
import com.rabbit.first.common.exception.CommonException;
import com.rabbit.first.common.exception.lifepay.LifePayException;
import com.rabbit.first.common.result.CommonErrorMessage;
import com.rabbit.first.common.util.AssertUtils;
import com.rabbit.first.dao.lifepay.LifePayBillDAO;
import com.rabbit.first.dao.lifepay.LifePayFamilyDAO;
import com.rabbit.first.dao.lifepay.LifePayPowerUseRecordDAO;
import com.rabbit.first.dao.lifepay.LifePayRecordDAO;
import com.rabbit.first.domain.lifepay.*;
import com.rabbit.first.dto.lifepay.LifePayRecordDTO;
import com.rabbit.first.dto.lifepay.params.LifePayRecordPDTO;
import com.rabbit.first.service.lifepay.client.LifePayRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class LifePayRecordlServiceImpl implements LifePayRecordService {
    @Autowired
    LifePayRecordDAO lprDAO;
    @Autowired
    LifePayFamilyDAO lpfDAO;
    @Autowired
    LifePayBillDAO lpbDAO;
    @Autowired
    LifePayPowerUseRecordDAO lppurDAO;

    @Override
    public void removeCostRecord(LifePayRecordPDTO paramsDTO) {

    }

    @Override
    public Object generateCostRecordByRecordMonth(LifePayRecordPDTO paramsDTO) throws CommonException {

        if (null == paramsDTO) {
            throw new CommonException(CommonErrorMessage.INTERFACE_NO_PARAMS_ERR);
        }
        Integer billMonth = paramsDTO.getBillMonth();
        if (null == billMonth) {
            throw new CommonException(CommonErrorMessage.INTERFACE_NO_PARAMS_NEEDED_ERR);
        }
        LifePayBillDO bill = lpbDAO.findByRecordMonth(billMonth);
        if (null == bill) {
            //todo 抛出当月账单还未生成异常
            throw new LifePayException(CommonErrorMessage.LIFEPAY_NO_BILL_GENERATOR_ERR);
        }
        Double powerBill = bill.getPowerBill();
        Double waterBill = bill.getWaterBill();
        List<LifePayFamilyDO> familys = lpfDAO.findAll();
        if (AssertUtils.isListEmpty(familys)) {
            //todo 抛出找不到用户异常
            throw new LifePayException(CommonErrorMessage.LIFEPAY_NO_FAMILY_ERR);
        }

        LifePayPowerUseRecordDO powerCommonUseRecord = lppurDAO.findByRecordMonthAndFamilyNull(billMonth);
        if (null == powerCommonUseRecord) {
            throw new LifePayException(CommonErrorMessage.LIFEPAY_NO_COMMON_POWER_USE_RECORD_ERR);
        }
        Double powerCommonUse = powerCommonUseRecord.getPowerUse();
        //TODO 如果处理电费出现异常，捕获
        Map<Integer, Double> powerCostMap = null;
        try {
            powerCostMap = dealPowerBill(powerCommonUse, billMonth, powerBill, familys);
        } catch (CommonException e) {
            e.printStackTrace();
            return Constants.ERR;
        }
        //TODO 如果处理水费出现异常，捕获
        Map<Integer, Double> waterCostMap = null;
        try {
            waterCostMap = dealWaterBill(waterBill, familys);
        } catch (CommonException e) {
            e.printStackTrace();
            return Constants.ERR;
        }
        for (LifePayFamilyDO family : familys) {
            Integer familyId = family.getFamilyId();
            LifePayRecordDO record = new LifePayRecordDO();
            record.setFamily(family);
            record.setPowerCost(powerCostMap.get(familyId));
            record.setWaterCost(waterCostMap.get(familyId));
            record.setRecordMonth(billMonth);
            if (null != lprDAO.findByRecordMonthAndFamily(billMonth, family)) {
                continue;
            }
            lprDAO.save(record);
        }
        return Constants.OK;
    }


    /**
     * 分配各家电费
     *
     * @param powerCommonUse
     * @param billMonth
     * @param powerBill
     * @param familys
     * @return
     */
    protected Map<Integer, Double> dealPowerBill(Double powerCommonUse, Integer billMonth, Double powerBill, List<LifePayFamilyDO> familys) throws CommonException {
        Map<Integer, Double> powerCostMap = new HashMap<>();
//        Double powerCommonUse = 0.0;
        Double powerTotalUse = 0.0;
        powerTotalUse += powerCommonUse;
        Map<Integer, Double> powerUseMap = new HashMap<>();
        for (LifePayFamilyDO family : familys) {
            Set<LifePayPowerUseRecordDO> powerUseRecords = family.getPowerUseRecords();
            Integer familyId = family.getFamilyId();
            if (AssertUtils.isSetEmpty(powerUseRecords)) {
                break;
            }
            for (LifePayPowerUseRecordDO powerUseRecord : powerUseRecords) {
                if (billMonth.equals(powerUseRecord.getRecordMonth())) {
                    powerUseMap.put(familyId, powerUseRecord.getPowerUse());
                    powerTotalUse += powerUseRecord.getPowerUse();
//                    System.out.println("powerUse--->" + powerUseRecord.getPowerUse());
//                    System.out.println("powerCommonUse ever time--->" + powerCommonUse);
                }
            }
        }
//        System.out.println("powerCommonUse--->" + powerCommonUse + "  powerTotalUse--->" + powerTotalUse);
        Map<Integer, Double> commonPowerUsedestributeMap = dealCommonPowerUse(powerCommonUse, familys);
        if (AssertUtils.isMapEmpty(commonPowerUsedestributeMap)) {
            //todo 抛出公共用电分配失败异常，生成当月消费记录方法全部回滚
            throw new LifePayException(CommonErrorMessage.LIFEPAY_COMMON_POWER_USE_DESTRIBUTE_FAIL_ERR);
        }
        for (Map.Entry<Integer, Double> entry : powerUseMap.entrySet()) {
            Integer familyId = entry.getKey();
            Double powerUse = entry.getValue();
//            System.out.println("familyId--->" + familyId + "  powerUse--->" + powerUse + "  commonPowerUsedestribute--->" + commonPowerUsedestributeMap.get(familyId));
            Double powerCost = powerBill * (powerUse + commonPowerUsedestributeMap.get(familyId)) / powerTotalUse;
            powerCostMap.put(familyId, powerCost);
        }
        return powerCostMap;
    }

    /**
     * 处理公共用电部分
     * 按照各家庭人头分配
     *
     * @param commonPowerUse
     * @param familys
     * @return
     */
    protected Map<Integer, Double> dealCommonPowerUse(Double commonPowerUse, List<LifePayFamilyDO> familys) throws CommonException {
        Map<Integer, Double> commonPowerUseDestributeMap = new HashMap<>();
        Map<Integer, Double> familyUseRateMap = generateFamilyDestributeRate(familys);
        if (AssertUtils.isMapEmpty(familyUseRateMap)) {
            //todo 抛出生成分摊比例异常，生成当月消费记录方法全部回滚
            throw new LifePayException(CommonErrorMessage.LIFEPAY_FAMILY_DESTRIBUTE_RATE_GENERATOR_FAIL_ERR);
        }
        for (Map.Entry<Integer, Double> entry : familyUseRateMap.entrySet()) {
            Integer familyId = entry.getKey();
            Double familyUseRate = entry.getValue();
            if (0 == familyUseRate) {
                //todo 抛出生成分摊比例异常，生成当月消费记录方法全部回滚
                throw new LifePayException(CommonErrorMessage.LIFEPAY_FAMILY_DESTRIBUTE_RATE_GENERATOR_FAIL_ERR);
            }
            Double commonPowerUseAfterDestribute = commonPowerUse * familyUseRate;
            commonPowerUseDestributeMap.put(familyId, commonPowerUseAfterDestribute);
        }
        return commonPowerUseDestributeMap;
    }

    /**
     * 分配各家水费
     *
     * @param waterBill
     * @param familys
     * @return
     */
    protected Map<Integer, Double> dealWaterBill(Double waterBill, List<LifePayFamilyDO> familys) throws CommonException {
        Map<Integer, Double> waterCostMap = new HashMap<>();
        Map<Integer, Double> familyUseRateMap = generateFamilyDestributeRate(familys);
        if (AssertUtils.isMapEmpty(familyUseRateMap)) {
            //todo 抛出生成分摊比例异常，生成当月消费记录方法全部回滚
            throw new LifePayException(CommonErrorMessage.LIFEPAY_FAMILY_DESTRIBUTE_RATE_GENERATOR_FAIL_ERR);
        }
        for (Map.Entry<Integer, Double> entry : familyUseRateMap.entrySet()) {
            Integer familyId = entry.getKey();
            Double familyUseRate = entry.getValue();
            if (0 == familyUseRate) {
                //todo 抛出生成分摊比例异常，生成当月消费记录方法全部回滚
                throw new LifePayException(CommonErrorMessage.LIFEPAY_FAMILY_DESTRIBUTE_RATE_GENERATOR_FAIL_ERR);
            }
            Double waterCost = waterBill * familyUseRate;
            waterCostMap.put(familyId, waterCost);
        }

        return waterCostMap;
    }

    /**
     * 根据各家人数生成水费或公共电费的分摊比例
     *
     * @param familys
     * @return
     */
    protected Map<Integer, Double> generateFamilyDestributeRate(List<LifePayFamilyDO> familys) {
        Map<Integer, Double> familyUseRateMap = new HashMap<>();
        Map<Integer, Integer> familyMemberNumMap = new HashMap<>();
        Double allFamilyMemberNum = 0.0;
        for (LifePayFamilyDO family : familys) {
            Set<LifePayUserDO> familyMembers = family.getFamilyMembers();
            Integer familyId = family.getFamilyId();
            if (AssertUtils.isSetEmpty(familyMembers)) {
                familyMemberNumMap.put(familyId, 0);
                continue;
            }
            familyMemberNumMap.put(familyId, familyMembers.size());
            allFamilyMemberNum += familyMembers.size();
        }
        for (Map.Entry<Integer, Integer> entry : familyMemberNumMap.entrySet()) {
            Integer familyId = entry.getKey();
            Integer familyMemberNum = entry.getValue();
            if (0 == allFamilyMemberNum) {
                familyUseRateMap.put(entry.getKey(), 0.0);
                continue;
            }
            familyUseRateMap.put(familyId, familyMemberNum / allFamilyMemberNum);
        }
        return familyUseRateMap;
    }

    @Override
    public List<LifePayRecordDTO> listCostRecordByRecordMonth(LifePayRecordPDTO paramsDTO) throws CommonException {
        List<LifePayRecordDTO> records = new ArrayList<>();
        if (null == paramsDTO) {
            throw new CommonException(CommonErrorMessage.INTERFACE_NO_PARAMS_ERR);
        }
        Integer billMonth = paramsDTO.getBillMonth();
        if (null == billMonth) {
            throw new CommonException(CommonErrorMessage.INTERFACE_NO_PARAMS_NEEDED_ERR);
        }
        List<LifePayRecordDO> recordsRaw = lprDAO.findAllByRecordMonth(billMonth);
        if (AssertUtils.isListEmpty(recordsRaw)) {
            //TODO 抛出查询消费记录为空异常
            throw new LifePayException(CommonErrorMessage.LIFEPAY_FAMLILY_COST_RECORD_FETCH_FAIL_ERR);
        }
        for (LifePayRecordDO recordRaw : recordsRaw) {
            LifePayRecordDTO record = new LifePayRecordDTO();
            record.setHousemasterName(recordRaw.getFamily().getHousemasterName());
            record.setPowerCost(recordRaw.getPowerCost());
            record.setWaterCost(recordRaw.getWaterCost());
            record.setRecordMonth(recordRaw.getRecordMonth());
            record.setLastModifyDate(recordRaw.getLastModifyDate().toString());
            records.add(record);
        }
        return records;
    }
}
