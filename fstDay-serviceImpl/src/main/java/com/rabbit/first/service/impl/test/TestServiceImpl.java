package com.rabbit.first.service.impl.test;

import com.rabbit.first.common.exception.CommonException;
import com.rabbit.first.dao.test.TestDAO;
import com.rabbit.first.domain.test.TestDO;
import com.rabbit.first.dto.test.TestDTO;
import com.rabbit.first.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TestServiceImpl implements TestService {
    @Autowired
    TestDAO testDAO;

    @Override
    public List<TestDTO> get() throws CommonException {
        List<TestDO> testP = testDAO.findAll();
        List<TestDTO> result = new ArrayList<>();
        for (TestDO test : testP) {
            TestDTO temp = new TestDTO();
            temp.setId(test.getId());
            temp.setTitle(test.getTitle());
            temp.setMsg(test.getMsg());
            result.add(temp);
        }
        return result;
    }
}
