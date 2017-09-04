package com.rabbit.first.dto.lifepay.params;

import java.io.Serializable;

public class LifePayRecordPDTO implements Serializable {

    private Integer billMonth;

    public Integer getBillMonth() {
        return billMonth;
    }

    public void setBillMonth(Integer billMonth) {
        this.billMonth = billMonth;
    }
}
