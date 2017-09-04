package com.rabbit.first.dao.lifepay;

import com.rabbit.first.domain.lifepay.LifePayPowerUseRecordDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LifePayPowerUseRecordDAO extends JpaRepository<LifePayPowerUseRecordDO, Integer> {

    LifePayPowerUseRecordDO findByRecordMonthAndFamilyNull(Integer recordMonth);
}
