package com.example.vybs.core.data.db.appEntity
import javax.inject.Inject

class AppEntityRepository @Inject constructor(
    private val appEntityDao: AppEntityDao
) {

    suspend fun insertApp(app: AppEntity) {
        appEntityDao.insertApp(app)
    }

    suspend fun insertApps(apps: List<AppEntity>) {
        appEntityDao.insertApps(apps)
    }

    suspend fun getAllApps(): List<AppEntity> {
        return appEntityDao.getAllApps()
    }

}