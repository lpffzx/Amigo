package com.rabbit.first.service.impl.lifepay.client;

import com.rabbit.first.common.constant.Constants;
import com.rabbit.first.common.exception.CommonException;
import com.rabbit.first.common.result.CommonErrorMessage;
import com.rabbit.first.common.util.AssertUtils;
import com.rabbit.first.dao.lifepay.LifePayFamilyDAO;
import com.rabbit.first.dao.lifepay.LifePayPowerUseRecordDAO;
import com.rabbit.first.dao.lifepay.LifePayUserDAO;
import com.rabbit.first.dto.lifepay.LifePayUserDTO;
import com.rabbit.first.dto.lifepay.params.LifePayUserPDTO;
import com.rabbit.first.domain.lifepay.LifePayFamilyDO;
import com.rabbit.first.domain.lifepay.LifePayPowerUseRecordDO;
import com.rabbit.first.domain.lifepay.LifePayUserDO;
import com.rabbit.first.service.lifepay.client.LifePayUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class LifePayUserServiceImpl implements LifePayUserService {
    @Autowired
    LifePayFamilyDAO llfDAO;
    @Autowired
    LifePayUserDAO lpuDAO;
    @Autowired
    LifePayPowerUseRecordDAO lppurDAP;

    @Override
    public LifePayUserDTO createFamily(LifePayUserPDTO paramsDTO) throws CommonException {
        if (null == paramsDTO) {
            throw new CommonException(CommonErrorMessage.INTERFACE_NO_PARAMS_ERR);
        }
        /**
         * T后缀代表瞬态
         * P后缀代表持久态
         * */
        LifePayFamilyDO familyT = paramsDTO.getFamily();
        if (null == familyT) {
            //todo 抛出持久化单元为空异常
            throw new CommonException(CommonErrorMessage.INTERFACE_NO_PARAMS_NEEDED_ERR);
        }
        LifePayFamilyDO familyP = llfDAO.save(familyT);
        LifePayUserDTO result = new LifePayUserDTO();
        result.setFamilyId(familyP.getFamilyId());
        return result;
    }

    @Override
    public LifePayUserDTO updateFamilyInfo(LifePayUserPDTO paramsDTO) throws CommonException {
        return null;
    }

    @Override
    public Object addFamilyMember(LifePayUserPDTO paramsDTO) throws CommonException {
        if (null == paramsDTO) {
            //todo 抛出方法参数为空异常
            throw new CommonException(CommonErrorMessage.INTERFACE_NO_PARAMS_ERR);
        }
        Set<LifePayUserDO> familyMembers = paramsDTO.getFamilyMembers();
        Integer familyId = paramsDTO.getFamilyId();
        if (null == familyId) {
            //todo 抛出未选择家庭异常
            throw new CommonException(CommonErrorMessage.INTERFACE_NO_PARAMS_NEEDED_ERR);
        }
        if (AssertUtils.isSetEmpty(familyMembers)) {
            //todo 抛出未选择家庭成员异常
            throw new CommonException(CommonErrorMessage.INTERFACE_NO_PARAMS_NEEDED_ERR);
        }
        LifePayFamilyDO family = new LifePayFamilyDO();
        family.setFamilyId(familyId);
        for (LifePayUserDO familyMember : familyMembers) {
            familyMember.setFamily(family);
            lpuDAO.save(familyMember);
        }
        return Constants.OK;
    }

    @Override
    public Object recordPowerUseSituation(LifePayUserPDTO paramsDTO) throws CommonException {
        if (null == paramsDTO) {
            //todo 抛出方法参数为空异常
            throw new CommonException(CommonErrorMessage.INTERFACE_NO_PARAMS_ERR);
        }
        LifePayPowerUseRecordDO powerUseRecord = paramsDTO.getPowerUseRecord();
        if (null == powerUseRecord) {
            //todo 抛出未输入用电记录异常
            throw new CommonException(CommonErrorMessage.INTERFACE_NO_PARAMS_NEEDED_ERR);
        }
        Integer familyId = paramsDTO.getFamilyId();
        /**
         * 针对公共用电记录不绑定任何家庭
         * */
        if (null == familyId) {
            lppurDAP.save(powerUseRecord);
            return Constants.OK;
        }
        LifePayFamilyDO family = new LifePayFamilyDO();
        family.setFamilyId(familyId);
        powerUseRecord.setFamily(family);
        lppurDAP.save(powerUseRecord);
        return Constants.OK;
    }
}
