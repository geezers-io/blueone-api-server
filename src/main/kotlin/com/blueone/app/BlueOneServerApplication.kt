package com.blueone.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class BlueOneServerApplication

fun main(args: Array<String>) {
    runApplication<BlueOneServerApplication>(*args)
}
