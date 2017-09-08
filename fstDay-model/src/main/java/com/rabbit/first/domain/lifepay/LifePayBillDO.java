package com.rabbit.first.domain.lifepay;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "lifepay_bill", catalog = "")
public class LifePayBillDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bill_id", columnDefinition = "INT(11) COMMENT '账单id(主键)'")
    private int billId;

    @Basic
    @Column(name = "power_bill", columnDefinition = "DOUBLE(10,2) COMMENT '电费账单'")
    private Double powerBill;

    @Basic
    @Column(name = "power_rate", columnDefinition = "DOUBLE(10,2) COMMENT '用电量'")
    private Double powerRate;

    @Basic
    @Column(name = "water_bill", columnDefinition = "DOUBLE(10,2) COMMENT '水费账单'")
    private Double waterBill;

    @Basic
    @Column(name = "water_rate", columnDefinition = "DOUBLE(10,2) COMMENT '用水量'")
    private Double waterRate;

    @Basic(fetch = FetchType.LAZY)
//    @CreationTimestamp
    @UpdateTimestamp
    @Column(name = "last_modify_date", columnDefinition = "DATETIME COMMENT '修改时间'")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8:00")
    private Date lastModifyDate = new Date();

    @Basic
    @Column(name = "record_month", columnDefinition = "INT(2) COMMENT '记录月份'")
    private int recordMonth;

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public Double getPowerBill() {
        return powerBill;
    }

    public void setPowerBill(Double powerBill) {
        this.powerBill = powerBill;
    }

    public Double getPowerRate() {
        return powerRate;
    }

    public void setPowerRate(Double powerRate) {
        this.powerRate = powerRate;
    }

    public Double getWaterBill() {
        return waterBill;
    }

    public void setWaterBill(Double waterBill) {
        this.waterBill = waterBill;
    }

    public Double getWaterRate() {
        return waterRate;
    }

    public void setWaterRate(Double waterRate) {
        this.waterRate = waterRate;
    }

    //    public String getLastModifyDate() {
//        return lastModifyDate;
//    }
//
//    public void setLastModifyDate(String lastModifyDate) {
//        this.lastModifyDate = lastModifyDate;
//    }


    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public int getRecordMonth() {
        return recordMonth;
    }

    public void setRecordMonth(int recordMonth) {
        this.recordMonth = recordMonth;
    }
}
