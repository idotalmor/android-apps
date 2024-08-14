package com.example.vybs.features.intro.di

import android.content.Context
import android.content.pm.PackageManager
import com.example.vybs.features.intro.usecase.GetInstalledAppsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object IntroDIModule {

    @Provides
    @Singleton
    fun providePackageManager(@ApplicationContext context: Context): PackageManager {
        return context.packageManager
    }

    @Provides
    @Singleton
    fun provideGetInstalledAppsUseCase(packageManager: PackageManager): GetInstalledAppsUseCase {
        return GetInstalledAppsUseCase(packageManager)
    }
}
