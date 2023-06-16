package com.blueone.app.global.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BlueOneException::class)
    fun handleBlueOneException(exception: BlueOneException): ResponseEntity<HttpResponseError> =
            ResponseEntity
                .status(exception.httpStatus.value())
                .body(exception.createErrorDto())

}
