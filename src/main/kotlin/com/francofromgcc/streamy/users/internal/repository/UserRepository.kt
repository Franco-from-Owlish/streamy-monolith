package com.francofromgcc.streamy.users.internal.repository

import com.francofromgcc.streamy.users.internal.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Int> {
    fun findByEmail(email: String): User?
}
