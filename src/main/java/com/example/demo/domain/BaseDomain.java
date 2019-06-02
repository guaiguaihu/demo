package com.example.demo.domain;

import java.util.Date;

/**
 * BaseDomain
 *
 * @author liujinliang
 * @date 2019/5/21
 **/
public class BaseDomain {


    private String addName;

    private Date addTime;

    private String updateName;

    private Date updateTime;

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
