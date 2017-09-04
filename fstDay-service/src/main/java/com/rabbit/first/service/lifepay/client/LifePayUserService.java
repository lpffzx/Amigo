package com.rabbit.first.service.lifepay.client;

import com.rabbit.first.common.exception.CommonException;
import com.rabbit.first.dto.lifepay.LifePayUserDTO;
import com.rabbit.first.dto.lifepay.params.LifePayUserPDTO;

public interface LifePayUserService {
    /**
     * 创建家庭单位
     */
    LifePayUserDTO createFamily(LifePayUserPDTO paramsDTO) throws CommonException;

    /**
     * 更新家庭信息
     *
     * @param paramsDTO
     * @return
     * @throws CommonException
     */
    LifePayUserDTO updateFamilyInfo(LifePayUserPDTO paramsDTO) throws CommonException;

    /**
     * 添加家庭成员
     *
     * @param paramsDTO
     */
    Object addFamilyMember(LifePayUserPDTO paramsDTO) throws CommonException;


    /**
     * 录入当月每个家庭用电情况
     */
    Object recordPowerUseSituation(LifePayUserPDTO paramsDTO) throws CommonException;
}
