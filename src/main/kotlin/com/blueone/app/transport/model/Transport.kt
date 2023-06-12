package com.blueone.app.transport.model

import com.blueone.app.global.jpa.CreateUpdateDateSet
import com.blueone.app.user.model.User
import jakarta.persistence.*
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
        private val checkTime: Date,

        @Temporal(TemporalType.TIMESTAMP)
        private val endTime: Date,

        @Column(nullable = false)
        private val isPenalty: Boolean = false,

        @Temporal(TemporalType.TIMESTAMP)
        private val bookingDate: Date,

        @Embedded
        private val createUpdateDateSet: CreateUpdateDateSet
) {
    /** Getters **/
    fun getId(): Long { return this.id }
    fun getUser(): User { return this.user }
    fun getOrigin(): String { return this.origin }
    fun getWaypoint(): String { return this.waypoint }
    fun getDestination(): String { return this.destination }
    fun getCarModel(): String { return this.carModel }
    fun getCharge(): String { return this.charge }
    fun getSubsidy(): String { return this.subsidy }
    fun getRemark(): String { return this.remark }
    fun getCheckTime(): Date { return this.checkTime }
    fun getEndTime(): Date { return this.endTime }
    fun getIsPenalty(): Boolean { return this.isPenalty }
    fun getBookingDate(): Date { return this.bookingDate }
    fun getCreatedDate(): Date { return this.createUpdateDateSet.createdDate }
    fun getUpdatedDate(): Date { return this.createUpdateDateSet.updatedDate }

}
