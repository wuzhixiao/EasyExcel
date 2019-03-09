package com.nujnay.moment.server;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.List;

public class ResultInfoUserInfo {
    private String userId;

    @ExcelProperty(value = "贷款申请次数", index = 8)
    private int dksqTimes;

    @ExcelProperty(value = "贷款成功次数", index = 9)
    private int dksqsuccessTimes;

    private List<LoanData> mLoanDatas;


    public static class LoanData {
        @ExcelProperty(value = "贷款成功", index = 10)
        private String loanSucc1;

        @ExcelProperty(value = "订单还款状态", index = 11)
        private String ddkkstate;

        @ExcelProperty(value = "逾期天数", index = 12)
        private int yqdays;

        public String getLoanSucc1() {
            return loanSucc1;
        }

        public void setLoanSucc1(String loanSucc1) {
            this.loanSucc1 = loanSucc1;
        }

        public String getDdkkstate() {
            return ddkkstate;
        }

        public void setDdkkstate(String ddkkstate) {
            this.ddkkstate = ddkkstate;
        }

        public int getYqdays() {
            return yqdays;
        }

        public void setYqdays(int yqdays) {
            this.yqdays = yqdays;
        }
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public List<LoanData> getmLoanDatas() {
        return mLoanDatas;
    }

    public void setmLoanDatas(List<LoanData> mLoanDatas) {
        this.mLoanDatas = mLoanDatas;
    }
}
