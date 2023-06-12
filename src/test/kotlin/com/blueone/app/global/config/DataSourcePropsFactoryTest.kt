package com.blueone.app.global.config

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

class DataSourcePropsFactoryTest {

    @Test
    @DisplayName("지정되지 않은 프로필 이름이면 예외가 발생한다.")
    fun failed_invalid_profile_name() {
        val meaninglessProperties = LocalProperties()
        assertThrows(IllegalArgumentException::class.java) {
            DataSourcePropsFactory(
                "invalid", meaninglessProperties, meaninglessProperties, meaninglessProperties
            )
                .create()
        }
    }

}
