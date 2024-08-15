package com.example.vybs.core

import android.content.pm.PackageManager
import com.example.vybs.core.usecase.DrawableToByteArrayUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    @Singleton
    fun provideDrawableToByteArrayUseCase(packageManager: PackageManager): DrawableToByteArrayUseCase {
        return DrawableToByteArrayUseCase()
    }
}