package com.example.vybs.features.intro.usecase

import com.example.vybs.core.data.db.appEntity.AppEntityRepository
import com.example.vybs.features.intro.mapper.mapApplicationsToEntities
import javax.inject.Inject

class GetAndSaveAppsUseCase @Inject constructor(
    private val getInstalledAppsUseCase: GetInstalledAppsUseCase,
    private val appEntityRepository: AppEntityRepository
) {
    suspend fun execute() {
        val apps = getInstalledAppsUseCase.execute()
        appEntityRepository.insertApps(mapApplicationsToEntities(apps) )
    }
}
