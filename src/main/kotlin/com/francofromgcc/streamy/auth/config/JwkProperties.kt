package com.francofromgcc.streamy.auth.config

import org.springframework.boot.context.properties.ConfigurationProperties
import java.nio.file.Path

data class SingingKeySet(
    val privateKey: Path,
    val publicKey: Path,
)

@ConfigurationProperties("jwk")
data class JwkProperties(
    val keyPaths: List<SingingKeySet>,
    val accessTokenExpiration: Long,
    val refreshTokenExpiration: Long,
)
