package com.rabbit.first.domain.lifepay;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "lifepay_power_use_record")
public class LifePayPowerUseRecordDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "record_id", columnDefinition = "INT(11) COMMENT '记录id(主键)'")
    private int recordId;

    @Basic
    @Column(name = "power_use", nullable = false, columnDefinition = "DOUBLE(10,2) COMMENT '用电量'")
    private Double powerUse;

//    @Basic
//    @Column(name = "power_common_use", nullable = false, columnDefinition = "DOUBLE(10,2) COMMENT '公共用电'")
//    private Double powerCommonUse;

    @Basic(fetch = FetchType.LAZY)
    @UpdateTimestamp
    @Column(name = "last_modify_date", columnDefinition = "DATETIME COMMENT '修改时间'")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8:00")
    private Date lastModifyDate = new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "family_id", nullable = true)
    private LifePayFamilyDO family;

    @Basic
    @Column(name = "record_month", columnDefinition = "INT(2) COMMENT '记录月份'")
    private int recordMonth;

    public int getRecordMonth() {
        return recordMonth;
    }

    public void setRecordMonth(int recordMonth) {
        this.recordMonth = recordMonth;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public Double getPowerUse() {
        return powerUse;
    }

    public void setPowerUse(Double powerUse) {
        this.powerUse = powerUse;
    }

//    public Double getPowerCommonUse() {
//        return powerCommonUse;
//    }
//
//    public void setPowerCommonUse(Double powerCommonUse) {
//        this.powerCommonUse = powerCommonUse;
//    }

    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }


    public LifePayFamilyDO getFamily() {
        return family;
    }

    public void setFamily(LifePayFamilyDO family) {
        this.family = family;
    }
}
