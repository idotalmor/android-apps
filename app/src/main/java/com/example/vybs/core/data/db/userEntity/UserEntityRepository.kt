package com.example.vybs.core.data.db.userEntity
import javax.inject.Inject

class UserEntityRepository @Inject constructor(
    private val appEntityDao: UserEntityDao
) {

    suspend fun insertUser(user: UserEntity) {
        appEntityDao.insertUser(user)
    }

    suspend fun getUser(): UserEntity? {
        return appEntityDao.getFirstUser()
    }

}