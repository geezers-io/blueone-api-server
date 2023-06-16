package com.blueone.app.transport.model

import com.blueone.app.global.jpa.CreateUpdateDateSet
import com.blueone.app.user.model.User
import jakarta.persistence.*
import java.time.LocalDate
import java.util.Date

@Entity(name = "transports")
class Transport(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private val id: Long,

        @ManyToOne
        @JoinColumn(name = "user_id")
        private val user: User,

        @Column(nullable = false, length = 255)
        private val origin: String,

        @Column(nullable = true, length = 255)
        private val waypoint: String,

        @Column(nullable = false, length = 255)
        private val destination: String,

        @Column(nullable = false, length = 255)
        private val carModel: String,

        @Column(nullable = false, length = 255)
        private val charge: String,

        @Column(nullable = true, length = 255)
        private val subsidy: String,

        @Column(nullable = true, length = 255)
        private val remark: String,

        @Temporal(TemporalType.TIMESTAMP)
        private val checkTime: LocalDate,

        @Temporal(TemporalType.TIMESTAMP)
        private val endTime: LocalDate,

        @Column(nullable = false)
        private val isPenalty: Boolean = false,

        @Temporal(TemporalType.TIMESTAMP)
        private val bookingDate: LocalDate,

        @Embedded
        private val createUpdateDateSet: CreateUpdateDateSet
) {
    /** Getters **/
    fun getId(): Long = this.id
    fun getUser(): User = this.user
    fun getOrigin(): String = this.origin
    fun getWaypoint(): String = this.waypoint
    fun getDestination(): String = this.destination
    fun getCarModel(): String = this.carModel
    fun getCharge(): String = this.charge
    fun getSubsidy(): String = this.subsidy
    fun getRemark(): String = this.remark
    fun getCheckTime(): LocalDate = this.checkTime
    fun getEndTime(): LocalDate = this.endTime
    fun getIsPenalty(): Boolean = this.isPenalty
    fun getBookingDate(): LocalDate = this.bookingDate
    fun getCreatedDate(): LocalDate = this.createUpdateDateSet.createdDate
    fun getUpdatedDate(): LocalDate = this.createUpdateDateSet.updatedDate

}
