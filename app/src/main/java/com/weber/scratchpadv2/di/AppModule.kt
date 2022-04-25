package com.weber.scratchpadv2.di

import com.weber.scratchpadv2.screen.prepare.use_case.CounterPlayerUseCase
import com.weber.scratchpadv2.screen.prepare.use_case.CounterSpyUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Корневой модуль предоставления зависимостей
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providerCounterPlayerUseCase() = CounterPlayerUseCase()

    @Singleton
    @Provides
    fun providerCounterSpyPlayerUseCase() = CounterSpyUseCase()
}