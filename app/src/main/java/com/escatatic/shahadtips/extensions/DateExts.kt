package com.escatatic.shahadtips.extensions

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter
import timber.log.Timber

fun String.changeToAppSpecificDate(): String {
    val dateTime = DateTime(this).toString(DateTimeFormat.mediumDate())

    return if (dateTime == DateTime().toString(DateTimeFormat.mediumDate())){
        "Today"
    }else {
        dateTime
//        "${dateTime.dayOfWeek().asText} ${dateTime.dayOfMonth().get()} ${dateTime.monthOfYear().asText}"
    }
}