package com.example.vybs.features.intro.mapper

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import com.example.vybs.core.data.db.appEntity.AppEntity
import com.example.vybs.core.usecase.DrawableToByteArrayUseCase
import javax.inject.Inject

class MapApplicationInfoToAppEntityUseCase @Inject constructor(
    private val packageManager: PackageManager,
    private val drawableToByteArrayUseCase: DrawableToByteArrayUseCase
) {

    fun map(applicationInfo: ApplicationInfo): AppEntity {
        val appName = packageManager.getApplicationLabel(applicationInfo).toString()
        var iconByteArr:ByteArray? = null;
        try {
            val icon = packageManager.getApplicationIcon(applicationInfo.packageName)
             iconByteArr = drawableToByteArrayUseCase.execute(icon)

        } catch (e: Exception) {
            // Handle exception if the icon cannot be retrieved
        }

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

        val imageUrl = null
        val isSuggested = false
        val progressRate = 0.0f

        return AppEntity(
            packageName = applicationInfo.packageName,
            name = appName,
            imageUrl = imageUrl,
            isSuggested = isSuggested,
            category = category,
            progressRate = progressRate,
            icon = iconByteArr,
            installed = true
        )
    }
}