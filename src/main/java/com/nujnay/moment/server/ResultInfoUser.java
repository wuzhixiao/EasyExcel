package com.nujnay.moment.server;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.util.Date;

public class ResultInfoUser extends BaseRowModel {

//    @ExcelProperty(value = "数据来源")
//    private long unit;

    @ExcelProperty(value = "单位（万卢比）", index = 1)
    private String unit;

    @ExcelProperty(value = "用户账号", index = 2)
    private String userAccount;

    @ExcelProperty(value = "注册时间", index = 3)
    private String registTime;

    @ExcelProperty(value = "注册日期", index = 4)
    private String registDate;

    @ExcelProperty(value = "注册来源", index = 5)
    private String registFrom;

    @ExcelProperty(value = "注册包名", index = 6)
    private String registPakage;

    @ExcelProperty(value = "当前用户等级", index = 7)
    private String userLevel;

    @ExcelProperty(value = "贷款申请次数", index = 8)
    private int dksqTimes;

    @ExcelProperty(value = "贷款成功次数", index = 9)
    private int dksqsuccessTimes;

    @ExcelProperty(value = "贷款成功信息", index = 10)
    private String loanSucc1;
//
//    @ExcelProperty(value = "订单还款状态", index = 11)
//    private String ddkkstate;
//
//    @ExcelProperty(value = "逾期天数", index = 12)
//    private int yqdays;
//
//    @ExcelProperty(value = "贷款成功2", index = 13)
//    private String loanSucc2;
//
//    @ExcelProperty(value = "订单还款状态", index = 14)
//    private String ddkkstate2;
//
//    @ExcelProperty(value = "逾期天数", index = 15)
//    private int yqdays2;
//
//    @ExcelProperty(value = "贷款成功3", index = 16)
//    private String loanSucc3;
//
//    @ExcelProperty(value = "订单还款状态", index = 17)
//    private String ddkkstate3;
//
//    @ExcelProperty(value = "逾期天数", index = 18)
//    private int yqdays3;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

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

    public String getRegistFrom() {
        return registFrom;
    }

    public void setRegistFrom(String registFrom) {
        this.registFrom = registFrom;
    }

    public String getRegistPakage() {
        return registPakage;
    }

    public void setRegistPakage(String registPakage) {
        this.registPakage = registPakage;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public int getDksqTimes() {
        return dksqTimes;
    }

    public void setDksqTimes(int dksqTimes) {
        this.dksqTimes = dksqTimes;
    }

    public int getDksqsuccessTimes() {
        return dksqsuccessTimes;
    }

    public void setDksqsuccessTimes(int dksqsuccessTimes) {
        this.dksqsuccessTimes = dksqsuccessTimes;
    }

    public String getLoanSucc1() {
        return loanSucc1;
    }

    public void setLoanSucc1(String loanSucc1) {
        this.loanSucc1 = loanSucc1;
    }

//    public String getDdkkstate() {
//        return ddkkstate;
//    }
//
//    public void setDdkkstate(String ddkkstate) {
//        this.ddkkstate = ddkkstate;
//    }
//
//    public int getYqdays() {
//        return yqdays;
//    }
//
//    public void setYqdays(int yqdays) {
//        this.yqdays = yqdays;
//    }
//
//    public String getLoanSucc2() {
//        return loanSucc2;
//    }
//
//    public void setLoanSucc2(String loanSucc2) {
//        this.loanSucc2 = loanSucc2;
//    }
//
//    public String getDdkkstate2() {
//        return ddkkstate2;
//    }
//
//    public void setDdkkstate2(String ddkkstate2) {
//        this.ddkkstate2 = ddkkstate2;
//    }
//
//    public int getYqdays2() {
//        return yqdays2;
//    }
//
//    public void setYqdays2(int yqdays2) {
//        this.yqdays2 = yqdays2;
//    }
//
//    public String getLoanSucc3() {
//        return loanSucc3;
//    }
//
//    public void setLoanSucc3(String loanSucc3) {
//        this.loanSucc3 = loanSucc3;
//    }
//
//    public String getDdkkstate3() {
//        return ddkkstate3;
//    }
//
//    public void setDdkkstate3(String ddkkstate3) {
//        this.ddkkstate3 = ddkkstate3;
//    }
//
//    public int getYqdays3() {
//        return yqdays3;
//    }
//
//    public void setYqdays3(int yqdays3) {
//        this.yqdays3 = yqdays3;
//    }
}
