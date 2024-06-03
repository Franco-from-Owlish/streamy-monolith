package com.francofromgcc.streamy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class StreamyApplication

fun main(args: Array<String>) {
    runApplication<StreamyApplication>(*args)
}

@RestController
class MessageController {
    @GetMapping("/health")
    fun health() = "OK"
}
