package com.example.demo.domain;


/**
 * CostDomain
 *
 * @author liujinliang
 * @date 2019/6/1
 **/
public class CostDomain extends BaseDomain {
    private int page;
    private int limit;
    private Integer costId;
    private String costName;
    private String costAmount;
    private String remark;
    private String costRelatedModel;
    private Integer costRelatedId;

    public String getCostName() {
        return costName;
    }

    public void setCostName(String costName) {
        this.costName = costName;
    }

    public String getCostAmount() {
        return costAmount;
    }

    public void setCostAmount(String costAmount) {
        this.costAmount = costAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Integer getCostId() {
        return costId;
    }

    public void setCostId(Integer costId) {
        this.costId = costId;
    }
}
