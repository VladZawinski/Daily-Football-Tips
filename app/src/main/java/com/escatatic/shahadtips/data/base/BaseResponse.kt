package com.escatatic.shahadtips.data.base

abstract class BaseResponse <T> {
    abstract val success: Boolean
    abstract val data: T
}