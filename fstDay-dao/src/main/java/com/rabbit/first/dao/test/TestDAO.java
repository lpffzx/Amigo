package com.rabbit.first.dao.test;

import com.rabbit.first.domain.test.TestDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDAO extends JpaRepository<TestDO, Integer> {

}
