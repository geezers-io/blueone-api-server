package com.blueone.app.user.model

import jakarta.persistence.*
import java.util.Date

@Entity(name = "employments")
class Employment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "user_id")
    private val user: User,

    @Column(nullable = false, length = 32, name = "birth_of_date")
    private val birthDate: String,

    @Column(nullable = false, length = 32)
    private val licenseNumber: String,

    @Column(nullable = false, length = 32)
    private val licenseType: String,

    @Column(nullable = false, length = 32)
    private val insuranceNumber: String,

    @Column(nullable = false, length = 32)
    private val insuranceExpiredDate: Date,
) {
    /** Getters **/
    fun getId(): Long = this.id
    fun getBirthDate(): String = this.birthDate
    fun getLicenseNumber(): String = this.licenseNumber
    fun getLicenseType(): String = this.licenseType
    fun getInsuranceNumber(): String = this.insuranceNumber
    fun getInsuranceExpiredDate(): Date = this.insuranceExpiredDate

}
