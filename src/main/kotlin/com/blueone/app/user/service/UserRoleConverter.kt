package com.blueone.app.user.service

class UserRoleConverter {

    fun deserialize(role: UserRole): String = when (role) {
        UserRole.ADMIN -> "admin"
        UserRole.USER -> "user"
    }

    fun serialize(roleAsString: String): UserRole = when (roleAsString) {
        "admin" -> UserRole.ADMIN
        "user" -> UserRole.USER
        else -> throw IllegalArgumentException("해당 문자열은 role 객체로 직렬화 할 수 없습니다.")
    }

}
