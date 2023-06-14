package com.blueone.app.user.model

import com.blueone.app.global.jpa.CreateUpdateDateSet
import com.blueone.app.user.service.UserRole
import com.blueone.app.user.service.UserRoleConverter
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDate

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
    private val createUpdateDateSet: CreateUpdateDateSet,

) {

    /** Getters **/
    fun getId(): Long { return this.id }
    fun getRole(): UserRole {
        return UserRoleConverter()
                .serialize(this.role)
    }
    fun getPhone(): String { return this.phone }
    fun getEncryptedPassword(): String { return this.password }
    fun getCreatedDate(): LocalDate { return this.createUpdateDateSet.createdDate }
    fun getUpdatedDate(): LocalDate { return this.createUpdateDateSet.updatedDate }

}
