package com.escatatic.shahadtips.data.model

import android.os.Build
import com.escatatic.shahadtips.data.mapper.Mapper
import com.escatatic.shahadtips.domain.models.Pick
import com.squareup.moshi.Json
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


data class PickDataModel(
    val match: MatchDataModel,
    val goals: GoalsDataModel,
    val result: String,
    @field:Json(name = "_id")
    val id: String,
    val tip: String,
    val dateOfTips: String,
    val createdAt: String,
    val updatedAt: String,
    val tipBy: String?,
    val markAs: String?
): Mapper<Pick> {

    override suspend fun map(): Pick {
        return Pick(match.map(),goals.map(),result, id, tip, createdAt.getFormattedDate(),tipBy,markAs)
    }

    private fun String.getFormattedDate(): String {
        return if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",Locale.ENGLISH)
            val outputFormat = DateTimeFormatter.ofPattern("dd MMM yyyy")
            val date = LocalDate.parse(this,inputFormat)

            outputFormat.format(date)
        } else {
            ""
        }
    }
}