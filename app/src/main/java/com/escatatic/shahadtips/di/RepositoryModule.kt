package com.escatatic.shahadtips.di

import com.escatatic.shahadtips.data.repository.AddMatchRepositoryImpl
import com.escatatic.shahadtips.data.repository.HomeRepositoryImpl
import com.escatatic.shahadtips.data.repository.MatchRepositoryImpl
import com.escatatic.shahadtips.domain.repository.AddMatchRepository
import com.escatatic.shahadtips.domain.repository.HomeRepository
import com.escatatic.shahadtips.domain.repository.MatchRepository
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

    @Singleton
    @Binds
    internal abstract fun provideAddMatchRepository(impl: AddMatchRepositoryImpl): AddMatchRepository

    @Singleton
    @Binds
    internal abstract fun provideMatchRepository(impl: MatchRepositoryImpl): MatchRepository
}