package com.rabbit.first.common.exception;

import com.rabbit.first.common.constant.Constants;
import com.rabbit.first.common.result.CommonErrorMessage;

public class CommonException extends Exception {
    private Integer code = Constants.ERROR_CODE;

    public CommonException() {
        super();
    }

    public CommonException(CommonErrorMessage message) {
        super(message.getMsg());
        this.code = message.getCode();
    }

    public CommonException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public CommonException(Throwable cause) {
        super(cause);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
