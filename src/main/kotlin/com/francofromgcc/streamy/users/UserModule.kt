package com.francofromgcc.streamy.users

import com.francofromgcc.streamy.users.events.UserPasswordChange
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.francofromgcc.streamy.users.internal.User

@Service
class UserModule(private val events: ApplicationEventPublisher) {

    @Transactional
    fun passwordUpdate(user: User, password: String) {
        events.publishEvent(UserPasswordChange(user.uuid, password))
    }
}
