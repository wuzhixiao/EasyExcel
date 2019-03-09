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
    private String loanMoney;

    @ExcelProperty(value = "借款期限", index = 4)
    private String loanQixian;

    @ExcelProperty(value = "利率", index = 5)
    private double rate;

    @ExcelProperty(value = "利息", index = 6)
    private double lixi;

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
    private int yghzSum;

    @ExcelProperty(value = "预估坏账率", index = 25)
    private String yghzLv;

    @ExcelProperty(value = "预估单笔营业收入（仅到期应还费用不含逾期费用）", index = 26)
    private int ygyingshou;

    @ExcelProperty(value = "预估总体营业收入（仅到期应还费用不含逾期费用）", index = 27)
    private int ygyingshouSum;


}
