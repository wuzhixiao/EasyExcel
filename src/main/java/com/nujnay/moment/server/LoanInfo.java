package com.nujnay.moment.server;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.util.Date;


public class LoanInfo extends BaseRowModel {
    @ExcelProperty(value = "贷款编号", index = 0)
    private long loanId;

    @ExcelProperty(value = "用户编号", index = 1)
    private String userId;

    @ExcelProperty(value = "申请金额", index = 2)
    private double applicationAmount;

    @ExcelProperty(value = "申请天数", index = 3)
    private int applicationdays;

    @ExcelProperty(value = "申请时间", index = 4, format = "yyyy/MM/dd hh：mm：ss")
    private Date applicationTime;


    @ExcelProperty(value = "当前状态", index = 5)
    private String stateNow;

    @ExcelProperty(value = "放款时间", index = 6, format = "yyyy/MM/dd hh：mm：ss")
    private Date loanTime;

    @ExcelProperty(value = "标签", index = 7)
    private String label;

    @ExcelProperty(value = "app包名", index = 8)
    private String appName;

    @ExcelProperty(value = "App版本号", index = 9)
    private String apkVersion;

    @ExcelProperty(value = "利率", index = 10)
    private double rate;

    @ExcelProperty(value = "服务费", index = 11)
    private double servicefee;

    @ExcelProperty(value = "扣款方式", index = 12)
    private String deductionway;

    @ExcelProperty(value = "实际放款金额", index = 13)
    private double loanAmountActual;

    @ExcelProperty(value = "应还款时间", index = 14, format = "yyyy/MM/dd HH:mm:ss")
    private Date returnMoneyshuldTime;

    @ExcelProperty(value = "应还本金", index = 15)
    private double returnMoneyPrincipal;

    @ExcelProperty(value = "应还利息", index = 16)
    private double returnMoneyRate;

    @ExcelProperty(value = "应还服务费", index = 17)
    private double returnMoneyService;

    @ExcelProperty(value = "应还罚息", index = 18)
    private double returnMoneyPenalty;

    @ExcelProperty(value = "结清时间", index = 19, format = "yyyy/MM/dd HH:mm:ss")
    private Date settleTime;

    @ExcelProperty(value = "已还款金额", index = 20)
    private double returnMoneyAlready;

    @ExcelProperty(value = "拒绝阶段", index = 21)
    private String rejectStage;

    @ExcelProperty(value = "拒绝理由", index = 22)
    private String reasonRefusal;

    @ExcelProperty(value = "当前催收员", index = 23)
    private String recruiterNow;

    @ExcelProperty(value = "用户手机号", index = 24)
    private String userPhone;

    @ExcelProperty(value = "用户姓名", index = 25)
    private String userName;

    @ExcelProperty(value = "用户KTP", index = 26)
    private String userKTP;

    @ExcelProperty(value = "注册时间", index = 27, format = "yyyy/MM/dd HH:mm:ss")
    private Date registTime;

    @ExcelProperty(value = "用户等级", index = 28)
    private String userlevel;

    @ExcelProperty(value = "来源渠道", index = 29)
    private String appFrom;

    @ExcelProperty(value = "居住省", index = 30)
    private String province;

    @ExcelProperty(value = "居住市", index = 31)
    private String city;

    @ExcelProperty(value = "居住区", index = 32)
    private String area;

    @ExcelProperty(value = "居住乡", index = 33)
    private String township;

    @ExcelProperty(value = "职业", index = 34)
    private String career;

    @ExcelProperty(value = "收入", index = 35)
    private String income;

    @ExcelProperty(value = "用户婚否", index = 36)
    private String userIsMarry;

    @ExcelProperty(value = "用户子女数", index = 37)
    private String childCount;

    @ExcelProperty(value = "用户居住时长", index = 38)
    private String LengthOfResidence;

    @ExcelProperty(value = "用户性别", index = 39)
    private String userSexy;

    @ExcelProperty(value = "用户借款用途", index = 40)
    private String loanUse;

    @ExcelProperty(value = "用户设备号", index = 41)
    private String usePhone;

    @ExcelProperty(value = "逾期天数", index = 42)
    private int OverdueDays;

    @ExcelProperty(value = "年龄", index = 43)
    private int age;

    public String getUsePhone() {
        return usePhone;
    }

    public void setUsePhone(String usePhone) {
        this.usePhone = usePhone;
    }

    public long getLoanId() {
        return loanId;
    }

    public void setLoanId(long loanId) {
        this.loanId = loanId;
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

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }


    public String getStateNow() {
        return stateNow;
    }

    public void setStateNow(String stateNow) {
        this.stateNow = stateNow;
    }

    public Date getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(Date loanTime) {
        this.loanTime = loanTime;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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

    public Date getReturnMoneyshuldTime() {
        return returnMoneyshuldTime;
    }

    public void setReturnMoneyshuldTime(Date returnMoneyshuldTime) {
        this.returnMoneyshuldTime = returnMoneyshuldTime;
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

    public Date getSettleTime() {
        return settleTime;
    }

    public void setSettleTime(Date settleTime) {
        this.settleTime = settleTime;
    }

    public double getReturnMoneyAlready() {
        return returnMoneyAlready;
    }

    public void setReturnMoneyAlready(double returnMoneyAlready) {
        this.returnMoneyAlready = returnMoneyAlready;
    }

    public int getOverdueDays() {
        return OverdueDays;
    }

    public void setOverdueDays(int overdueDays) {
        OverdueDays = overdueDays;
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

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    public String getDeductionway() {
        return deductionway;
    }

    public void setDeductionway(String deductionway) {
        this.deductionway = deductionway;
    }

    public String getAppFrom() {
        return appFrom;
    }

    public void setAppFrom(String appFrom) {
        this.appFrom = appFrom;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getUserIsMarry() {
        return userIsMarry;
    }

    public void setUserIsMarry(String userIsMarry) {
        this.userIsMarry = userIsMarry;
    }

    public String getChildCount() {
        return childCount;
    }

    public void setChildCount(String childCount) {
        this.childCount = childCount;
    }

    public String getLengthOfResidence() {
        return LengthOfResidence;
    }

    public void setLengthOfResidence(String lengthOfResidence) {
        LengthOfResidence = lengthOfResidence;
    }

    public String getUserSexy() {
        return userSexy;
    }

    public void setUserSexy(String userSexy) {
        this.userSexy = userSexy;
    }

    public String getLoanUse() {
        return loanUse;
    }

    public void setLoanUse(String loanUse) {
        this.loanUse = loanUse;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
