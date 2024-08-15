package com.example.vybs.features.appList.di

import android.content.Context
import android.content.pm.PackageManager
import com.example.vybs.core.data.db.userEntity.UserEntityRepository
import com.example.vybs.core.usecase.DrawableToByteArrayUseCase
import com.example.vybs.features.appList.usecase.OpenAppIntentUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppListDIModule {

    @Provides
    @Singleton
    fun provideOpenAppIntent(
        @ApplicationContext context: Context,
        packageManager: PackageManager,
    ): OpenAppIntentUseCase {
        return OpenAppIntentUseCase(packageManager, context)
    }

}
