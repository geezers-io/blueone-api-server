package com.blueone.app.global.security

import com.blueone.app.user.service.UserRole
import org.springframework.security.core.GrantedAuthority

class BlueOneAuthority(private val userRole: UserRole) : GrantedAuthority {

    override fun getAuthority(): String = userRole.toString()

}
