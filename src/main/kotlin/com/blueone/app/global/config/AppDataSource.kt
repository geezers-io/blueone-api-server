package com.blueone.app.global.config

/**
 * 애플리케이션 운용 간 필요한 데이터베이스의 값을 보관합니다.
 */
interface AppDataSource {
    var url: String
    var username: String
    var password: String
}
