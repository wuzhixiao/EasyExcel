package com.nujnay.moment.server

import com.nujnay.moment.server.ExcelOperation.dateStrCompare
import java.awt.PrintGraphics
import java.text.SimpleDateFormat
import java.util.*

fun configureRevebyeAnalysis(orderlist: ArrayList<ResultInfo>) {
    println("a:::${orderlist.size}")
    val firstHash = HashMap<ConfigureRevenueAnalysisKey, ArrayList<ResultInfo>>()
    for (resultinfo in orderlist) {
        val keyOne = ConfigureRevenueAnalysisKey()
        keyOne.applicationDate = resultinfo.applicationDate
        if (firstHash.contains(keyOne)) {
            firstHash[keyOne]?.add(resultinfo)
        } else {
            val arrayList = ArrayList<ResultInfo>()
            arrayList.add(resultinfo)
            firstHash[keyOne] = arrayList
        }
    }
    val finalResult = firstHash.createOne("loanMoney")
            .createOne("loanQixian")
            .createOne("rate")
            .createOne("interest")
            .createOne("servicefee")
            .createOne("loanAmount")
            .createOne("returnMoneyAll")
    var a = 0
    for (entry in finalResult.entries) {
        val key = entry.key
        val resultInfoProduct = ResultInfoProduct()
        resultInfoProduct.applicationDate = key.applicationDate
        resultInfoProduct.loanMoney = key.loanMoney
        resultInfoProduct.loanQixian = key.loanQixian
        resultInfoProduct.rate = key.rate
        resultInfoProduct.interest = key.interest
        resultInfoProduct.servicefee = key.servicefee
        resultInfoProduct.loanAmount = key.loanAmount
        resultInfoProduct.returnMoneyAll = key.returnMoneyAll
        resultInfoProduct.hasMoney = key.returnMoneyAll - key.loanAmount
        resultInfoProduct.shenqingNum = entry.value.size
        var fangkuanNum = 0
        var expiredNum = 0
        var rerpayedNum = 0
        var repayedNormalNum = 0
        var overdueNum = 0
        var overdueRepayedNum = 0
        var overdueNoRepayedNum = 0
        var overdueS1 = 0
        var overdueS1Repayed = 0
        var overdueS1NoRepayed = 0
        for (resultInfo in entry.value) {
            a++
            if (resultInfo.loanTime != null) {
                fangkuanNum++
            }
            if (resultInfo.returnMoneyshuldTime != null) {
                if (checkIsExpire(resultInfo.returnMoneyshuldTime)) {
                    expiredNum++
                }
            }
            if (resultInfo.settleTime != null) {
                rerpayedNum++
            }
            if (resultInfo.settleTime.before(resultInfo.returnMoneyshuldTime)) {
                repayedNormalNum++
            }
            if (resultInfo.returnMoneyshuldTime != null) {
                if (resultInfo.settleTime == null) {
                    overdueNum++
                    overdueRepayedNum++
                    if (resultInfo.returnMoneyshuldTime.time < System.currentTimeMillis()) {
                        overdueNoRepayedNum++
                    }
                } else {
                    if (!resultInfo.settleTime.before(resultInfo.returnMoneyshuldTime)) {
                        overdueNum++
                        overdueRepayedNum++
                    }
                }
            }
            val overdue7 = resultInfo.returnMoneyshuldTime.time + 7 * 24 * 60 * 60 * 1000
            if (resultInfo.settleTime != null) {
                if (resultInfo.settleTime.time < overdue7) {
                    if (resultInfo.settleTime.time > resultInfo.returnMoneyshuldTime.time) {
                        overdueS1++
                        overdueS1Repayed++
                    }
                }
            } else {
                if (resultInfo.returnMoneyshuldTime != null) {
                    if (System.currentTimeMillis() < overdue7) {
                        if (System.currentTimeMillis() > resultInfo.returnMoneyshuldTime.time) {
                            overdueS1++
                            overdueS1NoRepayed++
                        }
                    }
                }
            }
        }
        resultInfoProduct.fangkuanNum = fangkuanNum
        resultInfoProduct.daoqiNum = expiredNum
        resultInfoProduct.yihuanNum = rerpayedNum
        resultInfoProduct.zckqNum = repayedNormalNum
        resultInfoProduct.yuqiNum = overdueNum
        resultInfoProduct.yuqiyihNum = overdueRepayedNum
        resultInfoProduct.yuqiweihNum = overdueNoRepayedNum
        resultInfoProduct.s1yuqinum = overdueS1
        resultInfoProduct.s1yuqiyihNum = overdueS1Repayed
        resultInfoProduct.s1yuqiweihNum = overdueS1NoRepayed
        resultInfoProduct.yuqilv = resultInfoProduct.yuqiNum.toDouble() / resultInfoProduct.fangkuanNum.toDouble()
        resultInfoProduct.yghzSum = resultInfoProduct.yuqiweihNum.toDouble() * 0.6 + (resultInfoProduct.yuqiweihNum.toDouble() - resultInfoProduct.s1yuqiweihNum.toDouble()) * 0.9
    }
    println("a:::$a")
}

fun HashMap<ConfigureRevenueAnalysisKey, ArrayList<ResultInfo>>.createOne(copyNew: String): HashMap<ConfigureRevenueAnalysisKey, ArrayList<ResultInfo>> {
    val secondHash = HashMap<ConfigureRevenueAnalysisKey, ArrayList<ResultInfo>>()

    for (entry in this.entries) {
        val arrayList = entry.value
        val configureRevenueAnalysisKey = entry.key
        for (resultinfo in arrayList) {
            val keyOne = configureRevenueAnalysisKey.clone()
            fieldAssign(copyNew, keyOne, resultinfo)
            if (secondHash.contains(keyOne)) {
                secondHash[keyOne]?.add(resultinfo)
            } else {
                val resultInfos = ArrayList<ResultInfo>()
                resultInfos.add(resultinfo)
                secondHash[keyOne] = resultInfos
            }
        }
    }
    return secondHash
}

fun fieldAssign(name: String, key: ConfigureRevenueAnalysisKey, resultInfo: ResultInfo) {
    when (name) {
        "loanMoney" -> {
            key.loanMoney = resultInfo.applicationAmount
        }
        "loanQixian" -> {
            key.loanQixian = resultInfo.applicationdays
        }
        "rate" -> {
            key.rate = resultInfo.rate
        }
        "interest" -> {
            key.interest = resultInfo.returnMoneyRate
        }
        "servicefee" -> {
            key.servicefee = resultInfo.servicefee
        }
        "loanAmount" -> {
            key.loanAmount = resultInfo.loanAmountActual
        }
        "returnMoneyAll" -> {
            key.returnMoneyAll = resultInfo.returnMoneyAll
        }
    }
}

fun checkIsExpire(returnMoneyshuldTime: Date): Boolean {
    val returnMoneyTime = (SimpleDateFormat("yyyy/MM/dd")).format(returnMoneyshuldTime)
    val nowMilli = System.currentTimeMillis()
    val date = Date()
    date.time = nowMilli
    val now = (SimpleDateFormat("yyyy/MM/dd")).format(date)
    return dateStrCompare(now, returnMoneyTime) != 0
}

