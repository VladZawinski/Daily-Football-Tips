package com.escatatic.shahadtips.extensions

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter

fun String.changeToAppSpecificDate(): String {
    val dateTime = DateTime(this)
    return if (dateTime == DateTime()){
        "Today"
    }else {
        dateTime.toString(DateTimeFormat.mediumDate())
//        "${dateTime.dayOfWeek().asText} ${dateTime.dayOfMonth().get()} ${dateTime.monthOfYear().asText}"
    }
}