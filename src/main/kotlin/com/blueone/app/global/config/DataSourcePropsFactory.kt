package com.blueone.app.global.config

import java.lang.IllegalArgumentException

class DataSourcePropsFactory(
    private val profile: String,
    private val localProperties: AppDataSource,
    private val prodProperties: AppDataSource,
    private val testProperties: AppDataSource
) {

    fun create(): AppDataSource {
        return when (profile) {
            "dev" -> localProperties
            "prod" -> prodProperties
            "test" -> testProperties
            else -> throw IllegalArgumentException("Invalid Property(profileName) Name :(")
        }
    }

}
