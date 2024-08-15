package com.example.vybs.features.intro.mapper

import android.content.pm.ApplicationInfo
import com.example.vybs.core.data.db.appEntity.AppEntity
import javax.inject.Inject

class MapApplicationsToEntitiesUseCase @Inject constructor(
    private val mapApplicationInfoToAppEntityUseCase: MapApplicationInfoToAppEntityUseCase
) {

    fun map(apps: List<ApplicationInfo>): List<AppEntity> {
        return apps.map { mapApplicationInfoToAppEntityUseCase.map(it) }
    }
}