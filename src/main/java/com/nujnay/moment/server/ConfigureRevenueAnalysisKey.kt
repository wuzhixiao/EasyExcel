package com.nujnay.moment.server

import java.util.*

class ConfigureRevenueAnalysisKey : Cloneable {
    var applicationDate: String = ""
    var loanMoney: Double = 0.0
    var loanQixian: Int = 0
    var rate: Double = 0.0
    var interest: Double = 0.0
    var servicefee: Double = 0.0
    var loanAmount: Double = 0.0
    var returnMoneyAll: Double = 0.0

    public override fun clone(): ConfigureRevenueAnalysisKey {
        return super.clone() as ConfigureRevenueAnalysisKey
    }


    override fun hashCode(): Int {
        var hashcode = applicationDate.hashCode() + loanMoney.hashCode() + loanQixian.hashCode() + rate.hashCode() + interest.hashCode() + servicefee.hashCode() + loanAmount.hashCode() + returnMoneyAll.hashCode()
        return hashcode
    }

    override fun equals(other: Any?): Boolean {
        val keyOther = (other as ConfigureRevenueAnalysisKey)
        return keyOther.applicationDate == applicationDate
                && keyOther.loanMoney == loanMoney
                && keyOther.loanQixian == loanQixian
                && keyOther.rate == rate
                && keyOther.interest == interest
                && keyOther.servicefee == servicefee
                && keyOther.loanAmount == loanAmount
                && keyOther.returnMoneyAll == returnMoneyAll
    }

    override fun toString(): String {
        return "ConfigureRevenueAnalysisKey(applicationDate='$applicationDate', loanMoney=$loanMoney, loanQixian=$loanQixian, rate=$rate, interest=$interest, servicefee=$servicefee, loanAmount=$loanAmount, returnMoneyAll=$returnMoneyAll)"
    }


}