package com.nujnay.moment.server;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.util.Date;

public class ResultInfoNewUser extends BaseRowModel {

    @ExcelProperty(value = "注册时间", index = 2)
    private String registTime;

    @ExcelProperty(value = "注册日期", index = 3)
    private String registDate;

    @ExcelProperty(value = "注册人数", index = 4)
    private String registPeopleNum;

    @ExcelProperty(value = "申请笔数", index = 5)
    private String sqNum;

    @ExcelProperty(value = "放款笔数", index = 6)
    private String fkNum;

    @ExcelProperty(value = "注册-申请转化率", index = 7)
    private String zcSqLv;

    @ExcelProperty(value = "申请-放款转化率", index = 8)
    private String sqfkLv;

    @ExcelProperty(value = "注册-放款转化率", index = 9)
    private String zcfkLv;


    public String getRegistTime() {
        return registTime;
    }

    public void setRegistTime(String registTime) {
        this.registTime = registTime;
    }

    public String getRegistDate() {
        return registDate;
    }

    public void setRegistDate(String registDate) {
        this.registDate = registDate;
    }

    public String getRegistPeopleNum() {
        return registPeopleNum;
    }

    public void setRegistPeopleNum(String registPeopleNum) {
        this.registPeopleNum = registPeopleNum;
    }

    public String getSqNum() {
        return sqNum;
    }

    public void setSqNum(String sqNum) {
        this.sqNum = sqNum;
    }

    public String getFkNum() {
        return fkNum;
    }

    public void setFkNum(String fkNum) {
        this.fkNum = fkNum;
    }

    public String getZcSqLv() {
        return zcSqLv;
    }

    public void setZcSqLv(String zcSqLv) {
        this.zcSqLv = zcSqLv;
    }

    public String getSqfkLv() {
        return sqfkLv;
    }

    public void setSqfkLv(String sqfkLv) {
        this.sqfkLv = sqfkLv;
    }

    public String getZcfkLv() {
        return zcfkLv;
    }

    public void setZcfkLv(String zcfkLv) {
        this.zcfkLv = zcfkLv;
    }
}
