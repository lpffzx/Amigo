package com.rabbit.first.dao.lifepay;

import com.rabbit.first.domain.lifepay.LifePayFamilyDO;
import com.rabbit.first.domain.lifepay.LifePayRecordDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Mr.Rabbit on 2017/6/22.
 */
public interface LifePayRecordDAO extends JpaRepository<LifePayRecordDO, Integer> {

    List<LifePayRecordDO> findAllByRecordMonth(Integer recordMonth);

    LifePayRecordDO findByRecordMonthAndFamily(Integer recordMonth, LifePayFamilyDO family);

}
