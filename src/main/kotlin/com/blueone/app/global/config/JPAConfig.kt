package com.blueone.app.global.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class JPAConfig(private val localProperties: LocalProperties) {

    @Value("\${spring.profiles.active}")
    lateinit var profile: String

    @Bean
    fun dataSource(): DataSource {
        val dataSourceProperties: AppDataSource = DataSourcePropsFactory(
            profile,
            localProperties, localProperties, localProperties
        )
            .create()

        val dataSourceBuilder = DataSourceBuilder.create()
            .driverClassName("org.mariadb.jdbc.Driver")
            .url(dataSourceProperties.url)
            .username(dataSourceProperties.username)
            .password(dataSourceProperties.password)

        return dataSourceBuilder.build()
    }

}
