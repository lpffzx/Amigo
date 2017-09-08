package com.rabbit.first.service.test;

import com.rabbit.first.common.exception.CommonException;
import com.rabbit.first.dto.test.TestDTO;

import java.util.List;

public interface TestService {

    List<TestDTO> get() throws CommonException;
}
