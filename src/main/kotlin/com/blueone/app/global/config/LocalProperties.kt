package com.blueone.app.global.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "custom.datasource")
class LocalProperties : AppDataSource {
    override lateinit var url: String
    override lateinit var username: String
    override lateinit var password: String
}
