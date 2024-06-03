package com.francofromgcc.streamy.users.internal.services

import com.francofromgcc.streamy.users.UserModule
import com.francofromgcc.streamy.users.internal.User
import com.francofromgcc.streamy.users.internal.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userModule: UserModule
) {

    fun updatePassword(user: User, password: String) {
        userModule.passwordUpdate(user, password)
    }
}
