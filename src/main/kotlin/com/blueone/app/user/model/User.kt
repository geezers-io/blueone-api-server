package com.blueone.app.user.model

import com.blueone.app.global.jpa.CreateUpdateDateSet
import com.blueone.app.user.service.UserRole
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.*

@Entity(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,

    @Column(nullable = false, length = 20)
    private val role: String,

    @Column(nullable = false, length = 20)
    private val phone: String,

    @Column(nullable = false, length = 255)
    private val password: String,

    @Embedded
    private val createUpdateDateSet: CreateUpdateDateSet

) {

    /** Getters **/
    fun getId(): Long { return this.id }
    fun getRole(): UserRole { return serializeRole(this.role) }
    fun getPhone(): String { return this.phone }
    fun getEncryptedPassword(): String { return this.password }
    fun getCreatedDate(): Date { return this.createUpdateDateSet.createdDate }
    fun getUpdatedDate(): Date { return this.createUpdateDateSet.updatedDate }

    fun deserializeRole(role: UserRole): String = when (role) {
        UserRole.ADMIN -> "admin"
        UserRole.USER -> "user"
        else -> throw IllegalArgumentException("Invalid Role Argument")
    }

    fun serializeRole(roleAsString: String): UserRole = when (roleAsString) {
        "admin" -> UserRole.ADMIN
        "user" -> UserRole.USER
        else -> throw IllegalArgumentException("Invalid Role String Argument")
    }

}
