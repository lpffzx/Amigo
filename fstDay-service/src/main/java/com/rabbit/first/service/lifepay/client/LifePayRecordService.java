package com.rabbit.first.service.lifepay.client;

import com.rabbit.first.common.exception.CommonException;
import com.rabbit.first.dto.lifepay.LifePayRecordDTO;
import com.rabbit.first.dto.lifepay.params.LifePayRecordPDTO;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface LifePayRecordService {
    /**
     * 生成当月的消费记录
     */
    Object generateCostRecordByRecordMonth(LifePayRecordPDTO paramsDTO) throws CommonException;

    /**
     * 拉取所有家庭当月消费记录
     *
     * @return
     * @throws CommonException
     */
    @Cacheable(value = "lifePayRecordCache", key = "#paramsDTO.billMonth")
    List<LifePayRecordDTO> listCostRecordByRecordMonth(LifePayRecordPDTO paramsDTO) throws CommonException;


    /**
     * @param paramsDTO
     */
    @CacheEvict(value = "lifePayRecordCache", key = "#paramsDTO.billMonth")
    void removeCostRecord(LifePayRecordPDTO paramsDTO);


}
