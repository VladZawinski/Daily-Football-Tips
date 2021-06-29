package com.escatatic.shahadtips.di

import com.escatatic.shahadtips.base.Network
import com.escatatic.shahadtips.data.service.ShahadTipsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideShahadService() = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(Network.BASE)
        .build()
        .create(ShahadTipsService::class.java)
}