package com.rabbit.first.dto.lifepay.params;

import com.rabbit.first.domain.lifepay.LifePayFamilyDO;
import com.rabbit.first.domain.lifepay.LifePayPowerUseRecordDO;
import com.rabbit.first.domain.lifepay.LifePayUserDO;

import java.io.Serializable;
import java.util.Set;

public class LifePayUserPDTO implements Serializable {
    private Integer familyId;

    private Set<LifePayUserDO> familyMembers;

    private LifePayFamilyDO family;

    private LifePayPowerUseRecordDO powerUseRecord;

    public LifePayPowerUseRecordDO getPowerUseRecord() {
        return powerUseRecord;
    }

    public void setPowerUseRecord(LifePayPowerUseRecordDO powerUseRecord) {
        this.powerUseRecord = powerUseRecord;
    }

    public Integer getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
    }

    public LifePayFamilyDO getFamily() {
        return family;
    }

    public void setFamily(LifePayFamilyDO family) {
        this.family = family;
    }

    public Set<LifePayUserDO> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(Set<LifePayUserDO> familyMembers) {
        this.familyMembers = familyMembers;
    }
}
