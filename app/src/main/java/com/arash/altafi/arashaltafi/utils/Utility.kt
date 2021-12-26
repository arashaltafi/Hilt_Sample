package com.arash.altafi.arashaltafi.utils

import java.text.DecimalFormat

object Utility {

    fun priceConverter(price : String) : String {
        val decimalFormat = DecimalFormat("###,###")
        val prices = decimalFormat.format(Integer.valueOf(price))
        return "$prices ریال "
    }

    fun updateLowArz(update : String) : String
    {
        return " تغییرات اخیر : $update کاهش "
    }

    fun updateHighArz(update : String) : String
    {
        return " تغییرات اخیر : $update افزایش "
    }

}