package com.nujnay.moment.server;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.util.Date;

public class CustomerInfo extends BaseRowModel {
    @ExcelProperty(value = "用户编号", index = 0)
    private long userId;

    @ExcelProperty(value = "用户手机", index = 1)
    private String userPhone;

    @ExcelProperty(value = "用户姓名", index = 2)
    private String userName;

    @ExcelProperty(value = "注册时间", index = 3, format = "yyyy/MM/dd HH:mm:ss")
    private Date registTime;

    @ExcelProperty(value = "用户等级", index = 4)
    private String userlevel;

    @ExcelProperty(value = "用户婚否", index = 5)
    private String userIsMarry;

    @ExcelProperty(value = "用户子女数", index = 6)
    private String childCount;

    @ExcelProperty(value = "用户居住时长", index = 7)
    private String LengthOfResidence;

    @ExcelProperty(value = "用户性别", index = 8)
    private String userSexy;

    @ExcelProperty(value = "借款次数", index = 9)
    private int loanTimes;

    @ExcelProperty(value = "app包名", index = 10)
    private String appName;

    @ExcelProperty(value = "来源渠道", index = 11)
    private String appFrom;

    @ExcelProperty(value = "居住省", index = 12)
    private String province;

    @ExcelProperty(value = "居住市", index = 13)
    private String city;

    @ExcelProperty(value = "居住区", index = 14)
    private String area;

    @ExcelProperty(value = "居住乡", index = 15)
    private String township;

    @ExcelProperty(value = "职业", index = 16)
    private String career;

    @ExcelProperty(value = "收入", index = 17)
    private String income;

    @ExcelProperty(value = "证件号", index = 18)
    private String licenseNumber;

    @ExcelProperty(value = "年龄", index = 19)
    private int age;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    public String getUserlevel() {
        return userlevel;
    }

    public void setUserlevel(String userlevel) {
        this.userlevel = userlevel;
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

    public int getLoanTimes() {
        return loanTimes;
    }

    public void setLoanTimes(int loanTimes) {
        this.loanTimes = loanTimes;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
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

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
