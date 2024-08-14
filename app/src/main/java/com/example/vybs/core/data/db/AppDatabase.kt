package com.example.vybs.core.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.vybs.core.data.db.appEntity.AppEntity
import com.example.vybs.core.data.db.appEntity.AppEntityDao


@Database(entities = [AppEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appEntityDao(): AppEntityDao
}