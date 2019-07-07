package com.example.demo.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * OrderBusDomain
 *
 * @author liujinliang
 * @date 2019/5/31
 **/
public class OrderBusDomain extends BaseDomain {
    private Integer ordBusId;
    private Integer ordId;
    private Integer busId;
    private String route;
    private String busNo;
    private String busModel;
    private String driver;
    private String tel;
    private BigDecimal busCost;
    private String remark;
    private Date useBusStartTime;
    private Date useBusEndTime;

    public BigDecimal getBusCost() {
        return busCost;
    }

    public void setBusCost(BigDecimal busCost) {
        this.busCost = busCost;
    }

    public Date getUseBusStartTime() {
        return useBusStartTime;
    }

    public void setUseBusStartTime(Date useBusStartTime) {
        this.useBusStartTime = useBusStartTime;
    }

    public Date getUseBusEndTime() {
        return useBusEndTime;
    }

    public void setUseBusEndTime(Date useBusEndTime) {
        this.useBusEndTime = useBusEndTime;
    }

    public Integer getOrdBusId() {
        return ordBusId;
    }

    public void setOrdBusId(Integer ordBusId) {
        this.ordBusId = ordBusId;
    }

    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }

    public String getBusModel() {
        return busModel;
    }

    public void setBusModel(String busModel) {
        this.busModel = busModel;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
}
