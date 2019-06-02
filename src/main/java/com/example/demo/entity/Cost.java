package com.example.demo.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Cost {
    /**
     * 主键，费用ID
     */
    private Integer costId;

    /**
     * 费用定义表(aub_cost_define）主键
     */
    private Integer costDefineId;

    /**
     * 费用关联的模块（1：订单，2：车辆）
     */
    private String costRelatedModel;

    /**
     * 如果费用关联的是订单就是aub_order.ord_id
如果费用关联的是车辆就是aub_bus.bus_id
     */
    private Integer costRelatedId;

    /**
     * 费用名称
     */
    private String costName;

    /**
     * 费用金额
     */
    private BigDecimal costAmount;

    /**
     * 报销人
     */
    private String reimbursementor;

    /**
     * 报销日期
     */
    private Date reimbursementDate;

    /**
     * 姓名
     */
    private String addName;

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 删除标记 0未删除，1已删除
     */
    private Integer deleteFlag;

    /**
     * 删除人
     */
    private String deleteName;

    /**
     * 删除时间
     */
    private Date deleteTime;

    /**
     * 备注
     */
    private String remark;

    public Integer getCostId() {
        return costId;
    }

    public void setCostId(Integer costId) {
        this.costId = costId;
    }

    public Integer getCostDefineId() {
        return costDefineId;
    }

    public void setCostDefineId(Integer costDefineId) {
        this.costDefineId = costDefineId;
    }

    public String getCostRelatedModel() {
        return costRelatedModel;
    }

    public void setCostRelatedModel(String costRelatedModel) {
        this.costRelatedModel = costRelatedModel;
    }

    public Integer getCostRelatedId() {
        return costRelatedId;
    }

    public void setCostRelatedId(Integer costRelatedId) {
        this.costRelatedId = costRelatedId;
    }

    public String getCostName() {
        return costName;
    }

    public void setCostName(String costName) {
        this.costName = costName;
    }

    public BigDecimal getCostAmount() {
        return costAmount;
    }

    public void setCostAmount(BigDecimal costAmount) {
        this.costAmount = costAmount;
    }

    public String getReimbursementor() {
        return reimbursementor;
    }

    public void setReimbursementor(String reimbursementor) {
        this.reimbursementor = reimbursementor;
    }

    public Date getReimbursementDate() {
        return reimbursementDate;
    }

    public void setReimbursementDate(Date reimbursementDate) {
        this.reimbursementDate = reimbursementDate;
    }

    public String getAddName() {
        return addName;
    }

    public void setAddName(String addName) {
        this.addName = addName;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getDeleteName() {
        return deleteName;
    }

    public void setDeleteName(String deleteName) {
        this.deleteName = deleteName;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}