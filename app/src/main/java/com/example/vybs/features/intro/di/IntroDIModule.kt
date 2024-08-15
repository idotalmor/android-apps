package com.example.vybs.features.intro.di

import android.content.Context
import android.content.pm.PackageManager
import com.example.vybs.core.usecase.DrawableToByteArrayUseCase
import com.example.vybs.features.intro.mapper.MapApplicationInfoToAppEntityUseCase
import com.example.vybs.features.intro.mapper.MapApplicationsToEntitiesUseCase
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

    @Provides
    @Singleton
    fun providerMapApplicationInfoToAppEntityUseCase(packageManager: PackageManager,drawableToByteArrayUseCase:DrawableToByteArrayUseCase): MapApplicationInfoToAppEntityUseCase {
        return MapApplicationInfoToAppEntityUseCase(packageManager, drawableToByteArrayUseCase)
    }

    @Provides
    @Singleton
    fun providerMapApplicationsToEntitiesUseCase(mapApplicationInfoToAppEntityUseCase: MapApplicationInfoToAppEntityUseCase): MapApplicationsToEntitiesUseCase {
        return MapApplicationsToEntitiesUseCase(mapApplicationInfoToAppEntityUseCase)
    }
}
