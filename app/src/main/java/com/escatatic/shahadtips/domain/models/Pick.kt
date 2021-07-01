package com.escatatic.shahadtips.domain.models

data class Pick(
    val match: Match,
    val goals: Goals,
    val result: String,
    val id: String,
    val tip: String,
    val dateOfTips: String,
    val tipBy: String?,
    val badge: String?
)