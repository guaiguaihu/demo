package com.example.demo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * OrderDomain
 *
 * @author liujinliang
 * @date 2019/5/25
 **/
public class OrderDomain extends BaseDomain {
    private int page;
    private int limit;

    private List<OrderBusDomain> busList = new ArrayList<>();

    /**
     * 订单表主键
     */
    private Integer ordId;

    /**
     * 订单类型（外调）
     */
    private String ordType;
    private String status;

    /**
     * 用车开始时间
     */
    private String useBusStartTime;

    /**
     * 用车结束时间
     */
    private String useBusEndTime;

    /**
     * 用车开始时间
     */
    private String useBusStartDate;

    /**
     * 用车结束时间
     */
    private String useBusEndDate;

    /**
     * 合同编号
     */
    private String contractNo;

    /**
     * 合同金额
     */
    private Long contractAmount;

    /**
     * 预付合同金额
     */
    private Long preContractAmount;

    /**
     * 是否含费（0：不含，1：含费）
     */
    private Boolean containCost;

    /**
     * 上车点
     */
    private String addrGetOn;

    /**
     * 下车点
     */
    private String addrGetOff;

    /**
     * 付款方式
     */
    private String payType;

    /**
     * 备注
     */
    private String remark;

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
     * 用车单位
     */
    private String useBusCom;

    /**
     * 联系人
     */
    private String useBusContact;
    private String route;
    private String contactTel;

    public String getUseBusEndTime() {
        return useBusEndTime;
    }

    public void setUseBusEndTime(String useBusEndTime) {
        this.useBusEndTime = useBusEndTime;
    }

    public String getUseBusStartTime() {
        return useBusStartTime;
    }

    public void setUseBusStartTime(String useBusStartTime) {
        this.useBusStartTime = useBusStartTime;
    }

    public String getUseBusStartDate() {
        return useBusStartDate;
    }

    public void setUseBusStartDate(String useBusStartDate) {
        this.useBusStartDate = useBusStartDate;
    }

    public String getUseBusEndDate() {
        return useBusEndDate;
    }

    public void setUseBusEndDate(String useBusEndDate) {
        this.useBusEndDate = useBusEndDate;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Integer getOrdId() {
        return ordId;
    }

    public void setOrdId(Integer ordId) {
        this.ordId = ordId;
    }

    public String getOrdType() {
        return ordType;
    }

    public void setOrdType(String ordType) {
        this.ordType = ordType;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Long getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(Long contractAmount) {
        this.contractAmount = contractAmount;
    }

    public Long getPreContractAmount() {
        return preContractAmount;
    }

    public void setPreContractAmount(Long preContractAmount) {
        this.preContractAmount = preContractAmount;
    }

    public Boolean getContainCost() {
        return containCost;
    }

    public void setContainCost(Boolean containCost) {
        this.containCost = containCost;
    }

    public String getAddrGetOn() {
        return addrGetOn;
    }

    public void setAddrGetOn(String addrGetOn) {
        this.addrGetOn = addrGetOn;
    }

    public String getAddrGetOff() {
        return addrGetOff;
    }

    public void setAddrGetOff(String addrGetOff) {
        this.addrGetOff = addrGetOff;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String getAddName() {
        return addName;
    }

    @Override
    public void setAddName(String addName) {
        this.addName = addName;
    }

    @Override
    public Date getAddTime() {
        return addTime;
    }

    @Override
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    @Override
    public String getUpdateName() {
        return updateName;
    }

    @Override
    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    public String getUseBusCom() {
        return useBusCom;
    }

    public void setUseBusCom(String useBusCom) {
        this.useBusCom = useBusCom;
    }

    public String getUseBusContact() {
        return useBusContact;
    }

    public void setUseBusContact(String useBusContact) {
        this.useBusContact = useBusContact;
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

    public List<OrderBusDomain> getBusList() {
        return busList;
    }

    public void setBusList(List<OrderBusDomain> busList) {
        this.busList = busList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderDomain{" +
                "page=" + page +
                ", limit=" + limit +
                ", busList=" + busList +
                ", ordId=" + ordId +
                ", ordType='" + ordType + '\'' +
                ", status='" + status + '\'' +
                ", useBusStartTime=" + useBusStartTime +
                ", useBusEndTime='" + useBusEndTime + '\'' +
                ", useBusStartDate='" + useBusStartDate + '\'' +
                ", useBusEndDate=" + useBusEndDate +
                ", contractNo='" + contractNo + '\'' +
                ", contractAmount=" + contractAmount +
                ", preContractAmount=" + preContractAmount +
                ", containCost=" + containCost +
                ", addrGetOn='" + addrGetOn + '\'' +
                ", addrGetOff='" + addrGetOff + '\'' +
                ", payType='" + payType + '\'' +
                ", remark='" + remark + '\'' +
                ", addName='" + addName + '\'' +
                ", addTime=" + addTime +
                ", updateName='" + updateName + '\'' +
                ", updateTime=" + updateTime +
                ", deleteFlag=" + deleteFlag +
                ", deleteName='" + deleteName + '\'' +
                ", deleteTime=" + deleteTime +
                ", useBusCom='" + useBusCom + '\'' +
                ", useBusContact='" + useBusContact + '\'' +
                ", route='" + route + '\'' +
                ", contactTel='" + contactTel + '\'' +
                '}';
    }
}
