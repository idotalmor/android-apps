package com.example.vybs.core.data.db

import android.content.Context
import androidx.room.Room
import com.example.vybs.core.data.db.appEntity.AppEntityDao
import com.example.vybs.core.data.db.appEntity.AppEntityRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideAppDao(db: AppDatabase): AppEntityDao {
        return db.appEntityDao()
    }

    @Singleton
    @Provides
    fun provideAppRepository(appEntityDao: AppEntityDao): AppEntityRepository {
        return AppEntityRepository(appEntityDao)
    }
}