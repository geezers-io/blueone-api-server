package com.blueone.app.user.service

import org.junit.jupiter.api.Assertions.assertThrows
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class UserRoleConverterTest {
    private val userRoleConverter = UserRoleConverter()

    @Test
    @DisplayName("문자열인 사용자 권한 데이터를 성공적으로 사용자 권한 객체로 변환한다.")
    fun serialize_user_role_as_object() {
        assertThat(userRoleConverter.serialize("admin"))
                .isEqualTo(UserRole.ADMIN)
    }

    @Test
    @DisplayName("사용자 권한이 아닌 문자열은 예외가 발생된다.")
    fun exception_convert_invalid_data() {
        assertThrows(IllegalArgumentException::class.java) {
            userRoleConverter.serialize("invalid")
        }
    }

    @Test
    @DisplayName("사용자 권한 객체를 성공적으로 문자열로 변환된다.")
    fun deserialize_user_role() {
        assertThat(userRoleConverter.deserialize(UserRole.USER))
                .isEqualTo("user")
    }


}