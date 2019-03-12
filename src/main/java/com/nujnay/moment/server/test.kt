package com.nujnay.moment.server

import java.util.ArrayList
import java.util.HashMap

object test {
    @JvmStatic
    fun main(strings: Array<String>) {
        val a = ConfigureRevenueAnalysisKey()
        a.applicationDate = "aa"
        val b = a.clone()
        println(a)
        println(b)
        println(b.applicationDate)
        println(a === b)
    }
}
