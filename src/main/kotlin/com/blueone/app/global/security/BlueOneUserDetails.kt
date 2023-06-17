package com.blueone.app.global.security

import com.blueone.app.user.model.User
import com.blueone.app.user.service.UserRole
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.io.Serializable
import java.time.LocalDate

class BlueOneUserDetails(
        val id: Long,
        val role: UserRole,
        val phone: String,
        val rawPassword: String,
        val createdDate: LocalDate,
        val updatedDate: LocalDate
) : UserDetails, Serializable {
    private val authority = BlueOneAuthority(role)

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = mutableListOf(authority)
    override fun getPassword(): String = this.rawPassword
    override fun getUsername(): String = this.id.toString()
    override fun isAccountNonExpired() = false
    override fun isAccountNonLocked() = false
    override fun isCredentialsNonExpired() = false
    override fun isEnabled() = true

    companion object From {
        fun from(user: User): BlueOneUserDetails = with(user) {
            return BlueOneUserDetails(
                    id = id as Long,
                    role = getRole(),
                    phone = phone,
                    rawPassword = password,
                    createdDate = getCreatedDate(),
                    updatedDate = getUpdatedDate()
            )
        }
    }

}
