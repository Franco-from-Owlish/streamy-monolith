package com.francofromgcc.streamy.auth

import com.francofromgcc.streamy.auth.events.AuthUserLock
import com.francofromgcc.streamy.auth.internal.AuthUser
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class AuthModule(private val events: ApplicationEventPublisher) {
    fun lockUser(user: AuthUser) {
        events.publishEvent(AuthUserLock(user.uuid))
    }

    fun GetJwkSet(): List<JWK>
}
