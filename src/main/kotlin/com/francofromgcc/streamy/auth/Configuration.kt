package com.francofromgcc.streamy.auth

import org.springframework.boot.context.properties.EnableConfigurationProperties

import com.francofromgcc.streamy.auth.config.JwkProperties

@Configuration
@EnableConfigurationProperties(JwkProperties::class)
annotation class Configuration
