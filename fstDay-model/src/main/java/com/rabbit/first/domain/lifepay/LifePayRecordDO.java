package com.rabbit.first.domain.lifepay;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "lifepay_record", schema = "mydb")
public class LifePayRecordDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "record_id", columnDefinition = "INT(11) COMMENT '记录id(主键)'")
    private int recordId;

    @Basic
    @Column(name = "power_cost", columnDefinition = "DOUBLE(10,2) COMMENT '电费'")
    private Double powerCost;

    @Basic
    @Column(name = "water_cost", columnDefinition = "DOUBLE(10,2) COMMENT '水费'")
    private Double waterCost;

    @Basic(fetch = FetchType.LAZY)
//    @CreationTimestamp
    @UpdateTimestamp
    @Column(name = "last_modify_date", columnDefinition = "DATETIME COMMENT '修改时间'")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8:00")
    private Date lastModifyDate = new Date();

    @Basic
    @Column(name = "record_month", columnDefinition = "INT(2) COMMENT '记录月份'")
    private int recordMonth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "family_id", nullable = false)
    private LifePayFamilyDO family;

    public LifePayFamilyDO getFamily() {
        return family;
    }

    public void setFamily(LifePayFamilyDO family) {
        this.family = family;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public Double getPowerCost() {
        return powerCost;
    }

    public void setPowerCost(Double powerCost) {
        this.powerCost = powerCost;
    }

    public Double getWaterCost() {
        return waterCost;
    }

    public void setWaterCost(Double waterCost) {
        this.waterCost = waterCost;
    }

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
