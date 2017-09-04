package com.rabbit.first.domain.lifepay;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "lifepay_family", schema = "mydb")
public class LifePayFamilyDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "family_id", columnDefinition = "INT(11) COMMENT '家庭id(主键)'")
    private int familyId;

    @Basic
    @Column(name = "housemaster_name", nullable = false, columnDefinition = "VARCHAR(50) COMMENT '户主姓名'")
    private String housemasterName;

    @Basic(fetch = FetchType.LAZY)
//    @CreationTimestamp
    @UpdateTimestamp
    @Column(name = "last_modify_date", columnDefinition = "DATETIME COMMENT '修改时间'")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8:00")
    private Date lastModifyDate = new Date();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "family", cascade = CascadeType.ALL)
    @OrderBy(value = "name")
    private Set<LifePayUserDO> familyMembers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "family", cascade = CascadeType.ALL)
    @OrderBy(value = "recordMonth")
    private Set<LifePayRecordDO> records;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "family", cascade = CascadeType.ALL)
    @OrderBy(value = "recordMonth")
    private Set<LifePayPowerUseRecordDO> powerUseRecords;

    public Set<LifePayPowerUseRecordDO> getPowerUseRecords() {
        return powerUseRecords;
    }

    public void setPowerUseRecords(Set<LifePayPowerUseRecordDO> powerUseRecords) {
        this.powerUseRecords = powerUseRecords;
    }

    public Set<LifePayRecordDO> getRecords() {
        return records;
    }

    public void setRecords(Set<LifePayRecordDO> records) {
        this.records = records;
    }

    public Set<LifePayUserDO> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(Set<LifePayUserDO> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    public String getHousemasterName() {
        return housemasterName;
    }

    public void setHousemasterName(String housemasterName) {
        this.housemasterName = housemasterName;
    }


    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

}
