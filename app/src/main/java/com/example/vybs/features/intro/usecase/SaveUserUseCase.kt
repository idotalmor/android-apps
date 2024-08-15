package com.example.vybs.features.intro.usecase

import com.example.vybs.core.data.db.userEntity.UserEntity
import com.example.vybs.core.data.db.userEntity.UserEntityRepository
import javax.inject.Inject
import java.util.UUID

class SaveUserUseCase @Inject constructor(
    private val userEntityRepository: UserEntityRepository,
) {
    suspend fun execute(age:Int) {
        val userEntity = UserEntity(id = UUID.randomUUID().toString(),age = age)
        userEntityRepository.insertUser(userEntity)
    }
}
