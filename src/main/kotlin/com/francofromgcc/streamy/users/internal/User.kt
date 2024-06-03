package com.francofromgcc.streamy.users.internal

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "users_user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val uuid: UUID,

    val firstName: String,
    val lastName: String,

    val email: String,
    val phone: String
)
