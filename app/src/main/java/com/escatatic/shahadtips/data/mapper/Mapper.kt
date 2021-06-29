package com.escatatic.shahadtips.data.mapper

interface Mapper<T> {
    suspend fun map(): T
}