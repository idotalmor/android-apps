package com.example.vybs.features.appList.usecase

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import com.example.vybs.core.data.db.appEntity.AppEntity
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class OpenAppIntentUseCase @Inject constructor(
    private val packageManager: PackageManager,
    @ApplicationContext private val context: Context

) {
    fun execute(app: AppEntity) {
        val intent = packageManager.getLaunchIntentForPackage(app.packageName)

        if (intent != null) {
            // App is installed, open it
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        } else {
            // App is not installed, open Play Store
            val playStoreIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://play.google.com/store/apps/details?id=${app.packageName}")
            )
            playStoreIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

            context.startActivity(playStoreIntent)
        }
    }
}
