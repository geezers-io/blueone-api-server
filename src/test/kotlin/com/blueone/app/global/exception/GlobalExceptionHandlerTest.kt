package com.blueone.app.global.exception

import com.blueone.app.user.exception.UserNotFoundException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.bind.annotation.GetMapping

@WebMvcTest(GlobalExceptionHandlerTest.TestController::class)
class GlobalExceptionHandlerTest {
    private val mockMvc: MockMvc = MockMvcBuilders
            .standaloneSetup(TestController())
            .setControllerAdvice(GlobalExceptionHandler())
            .build()

    @Controller
    class TestController {
        @GetMapping("/user")
        fun getUser() {
            throw UserNotFoundException()
        }
    }

    @Test
    @DisplayName("예외 처리 요청에 대해 GlobalExceptionHandler 의 예외처리가 성공적으로 발생한다.")
    fun handle_blueone_servlet_exception() {
        // when && then
        mockMvc.get("/user") {
            accept = MediaType.APPLICATION_JSON
            characterEncoding = "utf-8"
        }
                .andExpect {
                    status { isNotFound() }
                    jsonPath("$.message") { isString() }
                }
    }

}
