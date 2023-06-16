package com.blueone.app.global.exception

import org.springframework.http.HttpStatusCode

open class BlueOneException(
        val httpStatus: HttpStatusCode,
        override val message: String
): Exception() {
    fun createErrorDto() = HttpResponseError(message)
}
