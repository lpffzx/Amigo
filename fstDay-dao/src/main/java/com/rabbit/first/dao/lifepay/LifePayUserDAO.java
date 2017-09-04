package com.rabbit.first.dao.lifepay;

import com.rabbit.first.domain.lifepay.LifePayUserDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LifePayUserDAO extends JpaRepository<LifePayUserDO, Integer> {

    LifePayUserDO getByName(String name);
}
