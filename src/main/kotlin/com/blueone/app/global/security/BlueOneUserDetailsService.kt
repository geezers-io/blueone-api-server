package com.blueone.app.global.security

import com.blueone.app.user.exception.UserNotFoundException
import com.blueone.app.user.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class BlueOneUserDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val userId = username.toLong()
        val user = userRepository.findById(userId)
                .orElseThrow { throw UserNotFoundException() }
        return BlueOneUserDetails.from(user)
    }

    fun loadUserById(userId: Long): UserDetails {
        val user = userRepository.findById(userId)
                .orElseThrow { throw UserNotFoundException() }
        return BlueOneUserDetails.from(user)
    }

}
