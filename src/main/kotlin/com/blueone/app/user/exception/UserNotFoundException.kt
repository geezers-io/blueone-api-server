package com.blueone.app.user.exception

import com.blueone.app.global.exception.BlueOneException
import org.springframework.http.HttpStatus

class UserNotFoundException : BlueOneException(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다.")
