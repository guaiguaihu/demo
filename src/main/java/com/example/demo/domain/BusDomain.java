package com.example.demo.domain;

import java.util.Date;
import java.util.List;

/**
 * BusDomain
 *
 * @author liujinliang
 * @date 2019/5/19
 **/
public class BusDomain extends BaseDomain{
    private int page;
    private int limit;
    private Integer busId;
    private String busNo;
    private String busModel;
    private String driver;
    private String tel;
    private String remark;
    private String status;
    private Date useBusStartTime;
    private Date useBusEndTime;
    private List<OrderDomain> orderDomainList;

    public List<OrderDomain> getOrderDomainList() {
        return orderDomainList;
    }

    public void setOrderDomainList(List<OrderDomain> orderDomainList) {
        this.orderDomainList = orderDomainList;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
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
}
