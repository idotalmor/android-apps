package com.example.vybs.core.data.db.appEntity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "apps")
data class AppEntity(
    @PrimaryKey val packageName: String,
    val name: String,
    val imageUrl: String?,
    val isSuggested: Boolean,
    val category: String,
    val progressRate: Float,
    val icon: ByteArray?,
    val installed: Boolean,
)