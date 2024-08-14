package com.example.vybs.features.intro.mapper

import android.content.pm.ApplicationInfo
import com.example.vybs.core.data.db.appEntity.AppEntity

fun mapApplicationInfoToAppEntity(
    applicationInfo: ApplicationInfo,
//    packageManager: PackageManager
): AppEntity {
    // Get the application label (name)
//    val appName = packageManager.getApplicationLabel(applicationInfo).toString()
    val appName = "packageManager.getApplicationLabel(applicationInfo).toString()"

    //TODO: fix name, imageURL, category
    // Map category integer to a string
    val category = when (applicationInfo.category) {
        ApplicationInfo.CATEGORY_ACCESSIBILITY -> "Accessibility"
        ApplicationInfo.CATEGORY_AUDIO -> "Audio"
        ApplicationInfo.CATEGORY_GAME -> "Game"
        ApplicationInfo.CATEGORY_IMAGE -> "Image"
        ApplicationInfo.CATEGORY_MAPS -> "Maps"
        ApplicationInfo.CATEGORY_NEWS -> "News"
        ApplicationInfo.CATEGORY_PRODUCTIVITY -> "Productivity"
        ApplicationInfo.CATEGORY_SOCIAL -> "Social"
        ApplicationInfo.CATEGORY_VIDEO -> "Video"
        else -> "Undefined"
    }

    // Assume default values for fields not present in ApplicationInfo
    val imageUrl = "default_image_url" // Replace with actual logic if available
    val isSuggested = false // Replace with actual logic if available
    val progressRate = 0.0f // Replace with actual logic if available

    return AppEntity(
        packageName = applicationInfo.packageName,
        name = appName,
        imageUrl = imageUrl,
        isSuggested = isSuggested,
        category = category,
        progressRate = progressRate
    )
}

fun mapApplicationsToEntities(apps:List<ApplicationInfo>
): List<AppEntity>{
    return apps.map {  mapApplicationInfoToAppEntity(it) }
}