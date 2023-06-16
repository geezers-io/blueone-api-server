package com.blueone.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BlueOneServerApplication

fun main(args: Array<String>) {
    runApplication<BlueOneServerApplication>(*args)
}
