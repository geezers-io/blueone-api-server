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
    val id: Long? = null,

    @Column(nullable = false, length = 20)
    private val role: String,

    @Column(nullable = false, length = 20)
    val phone: String,

    @Column(nullable = false, length = 255)
    val password: String,

    @Embedded
    val createUpdateDateSet: CreateUpdateDateSet,

    ) {

    /** Getters **/
    fun getRole(): UserRole = UserRoleConverter().serialize(this.role)
    fun getEncryptedPassword(): String = this.password
    fun getCreatedDate(): LocalDate = this.createUpdateDateSet.createdDate
    fun getUpdatedDate(): LocalDate = this.createUpdateDateSet.updatedDate

}
