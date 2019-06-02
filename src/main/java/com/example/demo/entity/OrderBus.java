package com.example.demo.entity;

import java.util.Date;

public class OrderBus {
    /**
     * 主键
     */
    private Integer recid;

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

    public Integer getRecid() {
        return recid;
    }

    public void setRecid(Integer recid) {
        this.recid = recid;
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
}