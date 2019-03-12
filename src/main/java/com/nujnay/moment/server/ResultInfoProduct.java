package com.nujnay.moment.server;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.util.Date;

public class ResultInfoProduct extends BaseRowModel {

//    @ExcelProperty(value = "数据来源")
//    private long unit;

    @ExcelProperty(value = "单位（万卢比）", index = 1)
    private String unit;

    @ExcelProperty(value = "申请日期", index = 2)
    private String applicationDate;

    @ExcelProperty(value = "借款金额", index = 3)
    private Double loanMoney;

    @ExcelProperty(value = "借款期限", index = 4)
    private int loanQixian;

    @ExcelProperty(value = "利率", index = 5)
    private double rate;

    @ExcelProperty(value = "利息", index = 6)
    private double interest;

    @ExcelProperty(value = "服务费", index = 8)
    private double servicefee;

    @ExcelProperty(value = "放款金额", index = 9)
    private double loanAmount;

    @ExcelProperty(value = "到期应还金额", index = 10)
    private double returnMoneyAll;

    @ExcelProperty(value = "每笔赚", index = 11)
    private double hasMoney;

    @ExcelProperty(value = "申请笔数", index = 12)
    private int shenqingNum;

    @ExcelProperty(value = "放款笔数", index = 13)
    private int fangkuanNum;

    @ExcelProperty(value = "到期笔数", index = 14)
    private int daoqiNum;

    @ExcelProperty(value = "已还笔数", index = 15)
    private int yihuanNum;

    @ExcelProperty(value = "正常还清笔数", index = 16)
    private int zckqNum;

    @ExcelProperty(value = "逾期笔数", index = 17)
    private int yuqiNum;

    @ExcelProperty(value = "逾期已还笔数", index = 18)
    private int yuqiyihNum;

    @ExcelProperty(value = "逾期未还笔数", index = 19)
    private int yuqiweihNum;

    @ExcelProperty(value = "S1逾期笔数", index = 20)
    private int s1yuqinum;

    @ExcelProperty(value = "S1逾期已还笔数", index = 21)
    private int s1yuqiyihNum;

    @ExcelProperty(value = "S1逾期未还笔数", index = 22)
    private int s1yuqiweihNum;

    @ExcelProperty(value = "逾期率", index = 23)
    private double yuqilv;

    @ExcelProperty(value = "预估坏账总量", index = 24)
    private double yghzSum;

    @ExcelProperty(value = "预估坏账率", index = 25)
    private String yghzLv;

    @ExcelProperty(value = "预估单笔营业收入（仅到期应还费用不含逾期费用）", index = 26)
    private int ygyingshou;

    @ExcelProperty(value = "预估总体营业收入（仅到期应还费用不含逾期费用）", index = 27)
    private int ygyingshouSum;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Double getLoanMoney() {
        return loanMoney;
    }

    public void setLoanMoney(Double loanMoney) {
        this.loanMoney = loanMoney;
    }

    public int getLoanQixian() {
        return loanQixian;
    }

    public void setLoanQixian(int loanQixian) {
        this.loanQixian = loanQixian;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getServicefee() {
        return servicefee;
    }

    public void setServicefee(double servicefee) {
        this.servicefee = servicefee;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getReturnMoneyAll() {
        return returnMoneyAll;
    }

    public void setReturnMoneyAll(double returnMoneyAll) {
        this.returnMoneyAll = returnMoneyAll;
    }

    public double getHasMoney() {
        return hasMoney;
    }

    public void setHasMoney(double hasMoney) {
        this.hasMoney = hasMoney;
    }

    public int getShenqingNum() {
        return shenqingNum;
    }

    public void setShenqingNum(int shenqingNum) {
        this.shenqingNum = shenqingNum;
    }

    public int getFangkuanNum() {
        return fangkuanNum;
    }

    public void setFangkuanNum(int fangkuanNum) {
        this.fangkuanNum = fangkuanNum;
    }

    public int getDaoqiNum() {
        return daoqiNum;
    }

    public void setDaoqiNum(int daoqiNum) {
        this.daoqiNum = daoqiNum;
    }

    public int getYihuanNum() {
        return yihuanNum;
    }

    public void setYihuanNum(int yihuanNum) {
        this.yihuanNum = yihuanNum;
    }

    public int getZckqNum() {
        return zckqNum;
    }

    public void setZckqNum(int zckqNum) {
        this.zckqNum = zckqNum;
    }

    public int getYuqiNum() {
        return yuqiNum;
    }

    public void setYuqiNum(int yuqiNum) {
        this.yuqiNum = yuqiNum;
    }

    public int getYuqiyihNum() {
        return yuqiyihNum;
    }

    public void setYuqiyihNum(int yuqiyihNum) {
        this.yuqiyihNum = yuqiyihNum;
    }

    public int getYuqiweihNum() {
        return yuqiweihNum;
    }

    public void setYuqiweihNum(int yuqiweihNum) {
        this.yuqiweihNum = yuqiweihNum;
    }

    public int getS1yuqinum() {
        return s1yuqinum;
    }

    public void setS1yuqinum(int s1yuqinum) {
        this.s1yuqinum = s1yuqinum;
    }

    public int getS1yuqiyihNum() {
        return s1yuqiyihNum;
    }

    public void setS1yuqiyihNum(int s1yuqiyihNum) {
        this.s1yuqiyihNum = s1yuqiyihNum;
    }

    public int getS1yuqiweihNum() {
        return s1yuqiweihNum;
    }

    public void setS1yuqiweihNum(int s1yuqiweihNum) {
        this.s1yuqiweihNum = s1yuqiweihNum;
    }

    public double getYuqilv() {
        return yuqilv;
    }

    public void setYuqilv(double yuqilv) {
        this.yuqilv = yuqilv;
    }

    public double getYghzSum() {
        return yghzSum;
    }

    public void setYghzSum(double yghzSum) {
        this.yghzSum = yghzSum;
    }

    public String getYghzLv() {
        return yghzLv;
    }

    public void setYghzLv(String yghzLv) {
        this.yghzLv = yghzLv;
    }

    public int getYgyingshou() {
        return ygyingshou;
    }

    public void setYgyingshou(int ygyingshou) {
        this.ygyingshou = ygyingshou;
    }

    public int getYgyingshouSum() {
        return ygyingshouSum;
    }

    public void setYgyingshouSum(int ygyingshouSum) {
        this.ygyingshouSum = ygyingshouSum;
    }
}
