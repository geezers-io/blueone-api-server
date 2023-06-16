package com.blueone.app.global.exception

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus

class BlueOneExceptionTest {

    @Test
    @DisplayName("BLUEONE 애플리케이션 전용 예외가 성공적으로 생성되고 예외 처리된다.")
    fun create_blueone_exception() {
        val blueOneException = BlueOneException(HttpStatus.BAD_REQUEST, "잘못된 요청입니다.")
        assertThrows(BlueOneException::class.java) {
            print(blueOneException)
            throw blueOneException
        }
    }

}