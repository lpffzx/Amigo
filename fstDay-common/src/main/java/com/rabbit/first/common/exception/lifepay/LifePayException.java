package com.rabbit.first.common.exception.lifepay;

import com.rabbit.first.common.exception.CommonException;
import com.rabbit.first.common.result.CommonErrorMessage;

public class LifePayException extends CommonException {
    public LifePayException(CommonErrorMessage message) {
        super(message);
    }
}
