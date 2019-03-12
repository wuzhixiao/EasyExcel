package com.nujnay.moment.server;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.util.Date;

public class ResultInfo extends BaseRowModel {

//    @ExcelProperty(value = "数据来源")
//    private long unit;
    @ExcelProperty(value = "单位（万卢比）", index = 1)
    private String unit;

    @ExcelProperty(value = "贷款编号", index = 2)
    private String loanId;

    @ExcelProperty(value = "当前状态", index = 3)
    private String stateNow;

    @ExcelProperty(value = "订单还款状态", index = 4)
    private String orderRepaymentState;

    @ExcelProperty(value = "用户编号", index = 5)
    private String userId;

    @ExcelProperty(value = "申请金额", index = 6)
    private double applicationAmount;

    @ExcelProperty(value = "申请天数", index = 7)
    private int applicationdays;

    @ExcelProperty(value = "利率", index = 8)
    private double rate;

    @ExcelProperty(value = "服务费", index = 9)
    private double servicefee;

    @ExcelProperty(value = "实际放款金额", index = 10)
    private double loanAmountActual;

    @ExcelProperty(value = "申请时间", index = 11, format = "yyyy/MM/dd HH:mm:ss")
    private Date applicationTime;

    @ExcelProperty(value = "申请日期", index = 12)
    private String applicationDate;

    @ExcelProperty(value = "放款时间", index = 13, format = "yyyy/MM/dd HH:mm:ss")
    private Date loanTime;

    @ExcelProperty(value = "放款日期", index = 14)
    private String loanDate;

    @ExcelProperty(value = "应还款时间", index = 15, format = "yyyy/MM/dd HH:mm:ss")
    private Date returnMoneyshuldTime;

    @ExcelProperty(value = "应还款日期", index = 16)
    private String returnMoneyshuldDate;

    @ExcelProperty(value = "到期应还金额", index = 17)
    private double returnMoneyAll;

    @ExcelProperty(value = "应还本金", index = 18)
    private double returnMoneyPrincipal;

    @ExcelProperty(value = "应还利息", index = 19)
    private double returnMoneyRate;

    @ExcelProperty(value = "应还服务费", index = 20)
    private double returnMoneyService;

    @ExcelProperty(value = "应还罚息", index = 21)
    private double returnMoneyPenalty;

    @ExcelProperty(value = "实际应还金额", index = 22)
    private double returnMoneyActual;

    @ExcelProperty(value = "已还款金额", index = 23)
    private double returnMoneyAlready;

    @ExcelProperty(value = "结清时间", index = 24, format = "yyyy/MM/dd HH:mm:ss")
    private Date settleTime;

    @ExcelProperty(value = "结清日期", index = 25)
    private String settleDate;

    @ExcelProperty(value = "逾期天数", index = 26)
    private int overdueDays;

    @ExcelProperty(value = "用户等级", index = 27)
    private String userlevel;

    @ExcelProperty(value = "拒绝阶段", index = 28)
    private String rejectStage;

    @ExcelProperty(value = "拒绝理由", index = 29)
    private String reasonRefusal;

    @ExcelProperty(value = "当前催收员", index = 30)
    private String recruiterNow;

    @ExcelProperty(value = "用户手机号", index = 31)
    private String userPhone;

    @ExcelProperty(value = "用户姓名", index = 32)
    private String userName;

    @ExcelProperty(value = "用户KTP", index = 33)
    private String userKTP;

    @ExcelProperty(value = "注册时间", index = 34)
    private String registTime;

    @ExcelProperty(value = "app包名", index = 35)
    private String appName;

    @ExcelProperty(value = "App版本号", index = 36)
    private String apkVersion;


    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getStateNow() {
        return stateNow;
    }

    public void setStateNow(String stateNow) {
        this.stateNow = stateNow;
    }

    public String getOrderRepaymentState() {
        return orderRepaymentState;
    }

    public void setOrderRepaymentState(String orderRepaymentState) {
        this.orderRepaymentState = orderRepaymentState;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getApplicationAmount() {
        return applicationAmount;
    }

    public void setApplicationAmount(double applicationAmount) {
        this.applicationAmount = applicationAmount;
    }

    public int getApplicationdays() {
        return applicationdays;
    }

    public void setApplicationdays(int applicationdays) {
        this.applicationdays = applicationdays;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getServicefee() {
        return servicefee;
    }

    public void setServicefee(double servicefee) {
        this.servicefee = servicefee;
    }

    public double getLoanAmountActual() {
        return loanAmountActual;
    }

    public void setLoanAmountActual(double loanAmountActual) {
        this.loanAmountActual = loanAmountActual;
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Date getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(Date loanTime) {
        this.loanTime = loanTime;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    public Date getReturnMoneyshuldTime() {
        return returnMoneyshuldTime;
    }

    public void setReturnMoneyshuldTime(Date returnMoneyshuldTime) {
        this.returnMoneyshuldTime = returnMoneyshuldTime;
    }

    public String getReturnMoneyshuldDate() {
        return returnMoneyshuldDate;
    }

    public void setReturnMoneyshuldDate(String returnMoneyshuldDate) {
        this.returnMoneyshuldDate = returnMoneyshuldDate;
    }

    public double getReturnMoneyAll() {
        return returnMoneyAll;
    }

    public void setReturnMoneyAll(double returnMoneyAll) {
        this.returnMoneyAll = returnMoneyAll;
    }

    public double getReturnMoneyPrincipal() {
        return returnMoneyPrincipal;
    }

    public void setReturnMoneyPrincipal(double returnMoneyPrincipal) {
        this.returnMoneyPrincipal = returnMoneyPrincipal;
    }

    public double getReturnMoneyRate() {
        return returnMoneyRate;
    }

    public void setReturnMoneyRate(double returnMoneyRate) {
        this.returnMoneyRate = returnMoneyRate;
    }

    public double getReturnMoneyService() {
        return returnMoneyService;
    }

    public void setReturnMoneyService(double returnMoneyService) {
        this.returnMoneyService = returnMoneyService;
    }

    public double getReturnMoneyPenalty() {
        return returnMoneyPenalty;
    }

    public void setReturnMoneyPenalty(double returnMoneyPenalty) {
        this.returnMoneyPenalty = returnMoneyPenalty;
    }

    public double getReturnMoneyActual() {
        return returnMoneyActual;
    }

    public void setReturnMoneyActual(double returnMoneyActual) {
        this.returnMoneyActual = returnMoneyActual;
    }

    public double getReturnMoneyAlready() {
        return returnMoneyAlready;
    }

    public void setReturnMoneyAlready(double returnMoneyAlready) {
        this.returnMoneyAlready = returnMoneyAlready;
    }

    public Date getSettleTime() {
        return settleTime;
    }

    public void setSettleTime(Date settleTime) {
        this.settleTime = settleTime;
    }

    public String getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate;
    }

    public int getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(int overdueDays) {
        overdueDays = overdueDays;
    }

    public String getUserlevel() {
        return userlevel;
    }

    public void setUserlevel(String userlevel) {
        this.userlevel = userlevel;
    }

    public String getRejectStage() {
        return rejectStage;
    }

    public void setRejectStage(String rejectStage) {
        this.rejectStage = rejectStage;
    }

    public String getReasonRefusal() {
        return reasonRefusal;
    }

    public void setReasonRefusal(String reasonRefusal) {
        this.reasonRefusal = reasonRefusal;
    }

    public String getRecruiterNow() {
        return recruiterNow;
    }

    public void setRecruiterNow(String recruiterNow) {
        this.recruiterNow = recruiterNow;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserKTP() {
        return userKTP;
    }

    public void setUserKTP(String userKTP) {
        this.userKTP = userKTP;
    }

    public String getRegistTime() {
        return registTime;
    }

    public void setRegistTime(String registTime) {
        this.registTime = registTime;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getApkVersion() {
        return apkVersion;
    }

    public void setApkVersion(String apkVersion) {
        this.apkVersion = apkVersion;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "unit='" + unit + '\'' +
                ", loanId='" + loanId + '\'' +
                ", stateNow='" + stateNow + '\'' +
                ", orderRepaymentState='" + orderRepaymentState + '\'' +
                ", userId='" + userId + '\'' +
                ", applicationAmount=" + applicationAmount +
                ", applicationdays=" + applicationdays +
                ", rate=" + rate +
                ", servicefee=" + servicefee +
                ", loanAmountActual=" + loanAmountActual +
                ", applicationTime=" + applicationTime +
                ", applicationDate='" + applicationDate + '\'' +
                ", loanTime=" + loanTime +
                ", loanDate='" + loanDate + '\'' +
                ", returnMoneyshuldTime=" + returnMoneyshuldTime +
                ", returnMoneyshuldDate='" + returnMoneyshuldDate + '\'' +
                ", returnMoneyAll=" + returnMoneyAll +
                ", returnMoneyPrincipal=" + returnMoneyPrincipal +
                ", returnMoneyRate=" + returnMoneyRate +
                ", returnMoneyService=" + returnMoneyService +
                ", returnMoneyPenalty=" + returnMoneyPenalty +
                ", returnMoneyActual=" + returnMoneyActual +
                ", returnMoneyAlready=" + returnMoneyAlready +
                ", settleTime=" + settleTime +
                ", settleDate='" + settleDate + '\'' +
                ", overdueDays=" + overdueDays +
                ", userlevel='" + userlevel + '\'' +
                ", rejectStage='" + rejectStage + '\'' +
                ", reasonRefusal='" + reasonRefusal + '\'' +
                ", recruiterNow='" + recruiterNow + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userName='" + userName + '\'' +
                ", userKTP='" + userKTP + '\'' +
                ", registTime='" + registTime + '\'' +
                ", appName='" + appName + '\'' +
                ", apkVersion='" + apkVersion + '\'' +
                '}';
    }
}
