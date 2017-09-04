package com.rabbit.first.dto.lifepay.params;

import com.rabbit.first.domain.lifepay.LifePayBillDO;

import java.io.Serializable;

public class LifePayBillPDTO implements Serializable {

    private LifePayBillDO bill;

    public LifePayBillDO getBill() {
        return bill;
    }

    public void setBill(LifePayBillDO bill) {
        this.bill = bill;
    }
}
