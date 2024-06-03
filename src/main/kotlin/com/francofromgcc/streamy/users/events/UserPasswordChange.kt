package com.francofromgcc.streamy.users.events

import org.jmolecules.event.annotation.Externalized
import java.util.UUID

@Externalized
data class UserPasswordChange(val userUUID: UUID, val password: String)
