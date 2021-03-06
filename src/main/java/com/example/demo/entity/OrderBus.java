package com.example.demo.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderBus {
    /**
     * 主键
     */
    private Integer ordBusId;

    /**
     * 订单ID，订单表主键
     */
    private Integer ordId;

    /**
     * 车辆信息表主键（aub_bus）
     */
    private Integer busId;

    /**
     * 车辆行程
     */
    private String route;
    private BigDecimal busCost;

    /**
     * 添加人
     */
    private String addName;

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 修改人
     */
    private String updateName;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 车牌号
     */
    private String busNo;

    /**
     * 驾驶员
     */
    private String driver;

    /**
     * 驾驶员电话
     */
    private String tel;

    /**
     * 车型
     */
    private String busModel;

    /**
     * 删除标记：0未删除，1已删除
     */
    private Integer deleteFlag;

    public BigDecimal getBusCost() {
        return busCost;
    }

    public void setBusCost(BigDecimal busCost) {
        this.busCost = busCost;
    }

    public Integer getOrdBusId() {
        return ordBusId;
    }

    public void setOrdBusId(Integer ordBusId) {
        this.ordBusId = ordBusId;
    }

    public Integer getOrdId() {
        return ordId;
    }

    public void setOrdId(Integer ordId) {
        this.ordId = ordId;
    }

    public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
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

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBusModel() {
        return busModel;
    }

    public void setBusModel(String busModel) {
        this.busModel = busModel;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}