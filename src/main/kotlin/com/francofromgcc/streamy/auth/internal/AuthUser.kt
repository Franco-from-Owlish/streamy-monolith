package com.francofromgcc.streamy.auth.internal

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "auth_auth_user")
data class AuthUser(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val uuid: UUID = UUID.randomUUID(),

    val email: String,
    val password: String
)
