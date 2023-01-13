package ru.bitc.webnet.di

import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.bitc.webnet.date.local.OpenAssetsFileProvider
import javax.inject.Singleton


/**
 * Предоставления зависимостей
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesOpenAssetsFileProvider(resources: Resources): OpenAssetsFileProvider {
        return OpenAssetsFileProvider(resources)
    }

    @Provides
    fun providesAndroidResources(@ApplicationContext context: Context): Resources =
        context.resources

}