package com.escatatic.shahadtips.di

import com.escatatic.shahadtips.data.repository.HomeRepositoryImpl
import com.escatatic.shahadtips.domain.repository.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    internal abstract fun provideHomeRepository(impl: HomeRepositoryImpl): HomeRepository
}