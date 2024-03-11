package com.example.coincalendar.extension

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Date.formatString(formatType : String) : String {

    return try {
        val simpleDateFormat = SimpleDateFormat(formatType, Locale.KOREA)
        simpleDateFormat.format(this)
    } catch (e : Exception) {
        e.printStackTrace()
        ""
    }
}