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

// Create individual mock AppEntity objects
val mockAppEntity1 = AppEntity(
    packageName = "com.example.app1",
    name = "Mock App 1",
    imageUrl = null,
    isSuggested = true,
    category = "Productivity",
    progressRate = 0.85f,
    icon = null,
    installed = true
)

val mockAppEntity2 = AppEntity(
    packageName = "com.example.app2",
    name = "Mock App 2",
    imageUrl = "https://via.placeholder.com/150/00FF00/FFFFFF?Text=App2",
    isSuggested = false,
    category = "Games",
    progressRate = 0.45f,
    icon = null,
    installed = false
)

val mockAppEntity3 = AppEntity(
    packageName = "com.example.app3",
    name = "Mock App 3",
    imageUrl = "https://via.placeholder.com/150/0000FF/FFFFFF?Text=App3",
    isSuggested = true,
    category = "Social",
    progressRate = 0.60f,
    icon = null,
    installed = true
)

val mockAppEntity4 = AppEntity(
    packageName = "com.example.app4",
    name = "Mock App 4",
    imageUrl = "https://via.placeholder.com/150/FFFF00/FFFFFF?Text=App4",
    isSuggested = true,
    category = "Health & Fitness",
    progressRate = 0.90f,
    icon = null,
    installed = false
)

val mockAppEntity5 = AppEntity(
    packageName = "com.example.app5",
    name = "Mock App 5",
    imageUrl = "https://via.placeholder.com/150/FF00FF/FFFFFF?Text=App5",
    isSuggested = false,
    category = "Education",
    progressRate = 0.75f,
    icon = null,
    installed = true
)

val mockAppEntity6 = AppEntity(
    packageName = "com.example.app6",
    name = "Mock App 6",
    imageUrl = "https://via.placeholder.com/150/00FFFF/FFFFFF?Text=App6",
    isSuggested = true,
    category = "Music & Audio",
    progressRate = 0.50f,
    icon = null,
    installed = false
)

val mockAppEntity7 = AppEntity(
    packageName = "com.example.app7",
    name = "Mock App 7",
    imageUrl = "https://via.placeholder.com/150/800000/FFFFFF?Text=App7",
    isSuggested = false,
    category = "Lifestyle",
    progressRate = 0.70f,
    icon = null,
    installed = true
)

val mockAppEntity8 = AppEntity(
    packageName = "com.example.app8",
    name = "Mock App 8",
    imageUrl = "https://via.placeholder.com/150/008000/FFFFFF?Text=App8",
    isSuggested = true,
    category = "Photography",
    progressRate = 0.55f,
    icon = null,
    installed = false
)

val mockAppEntity9 = AppEntity(
    packageName = "com.example.app9",
    name = "Mock App 9",
    imageUrl = "https://via.placeholder.com/150/000080/FFFFFF?Text=App9",
    isSuggested = false,
    category = "Travel & Local",
    progressRate = 0.95f,
    icon = null,
    installed = true
)

val mockAppEntity10 = AppEntity(
    packageName = "com.example.app10",
    name = "Mock App 10",
    imageUrl = "https://via.placeholder.com/150/808000/FFFFFF?Text=App10",
    isSuggested = true,
    category = "Shopping",
    progressRate = 0.65f,
    icon = null,
    installed = false
)

// Create a list containing all mock objects
val mockAppEntityList = listOf(
    mockAppEntity1,
    mockAppEntity2,
    mockAppEntity3,
    mockAppEntity4,
    mockAppEntity5,
    mockAppEntity6,
    mockAppEntity7,
    mockAppEntity8,
    mockAppEntity9,
    mockAppEntity10
)
