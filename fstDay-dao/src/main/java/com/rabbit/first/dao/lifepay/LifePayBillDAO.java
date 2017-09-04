package com.rabbit.first.dao.lifepay;

import com.rabbit.first.domain.lifepay.LifePayBillDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Mr.Rabbit on 2017/6/22.
 */
public interface LifePayBillDAO extends JpaRepository<LifePayBillDO, Integer> {

    LifePayBillDO findByRecordMonth(Integer recordMonth);

}
