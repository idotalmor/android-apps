package com.example.vybs.features.intro.usecase

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import javax.inject.Inject

class GetInstalledAppsUseCase @Inject constructor(
    private val packageManager: PackageManager
) {
    fun execute(): List<ApplicationInfo> {
        return packageManager.getInstalledApplications(PackageManager.GET_META_DATA)//TODO:research
    }
}
