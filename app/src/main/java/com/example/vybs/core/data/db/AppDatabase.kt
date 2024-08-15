package com.example.vybs.core.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.vybs.core.data.db.appEntity.AppEntity
import com.example.vybs.core.data.db.appEntity.AppEntityDao
import com.example.vybs.core.data.db.userEntity.UserEntity
import com.example.vybs.core.data.db.userEntity.UserEntityDao


@Database(entities = [AppEntity::class,UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appEntityDao(): AppEntityDao
    abstract fun userEntityDao(): UserEntityDao
}