package ru.bitc.webnet.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.bitc.webnet.date.remote.FlowInterviewTopicRepositoryImpl
import ru.bitc.webnet.domain.FlowInterviewTopicRepository

@Module
@InstallIn(SingletonComponent::class)
interface NetworkBindsModule {

    @Binds
    fun bindsFlowInterviewTopicRepository(
        flowInterviewTopicRepositoryImpl: FlowInterviewTopicRepositoryImpl
    ): FlowInterviewTopicRepository

}