package com.blueone.app.notice.model

import jakarta.persistence.*
import java.util.Date

@Entity(name = "notices")
class Notice(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,

    @Column(nullable = false, length = 255)
    private val title: String,

    @Column(nullable = false)
    private val content: String,

    @Temporal(TemporalType.TIMESTAMP)
    private val startDate: Date,

    @Temporal(TemporalType.TIMESTAMP)
    private val endDate: Date,

) {
    /** Getter **/
    fun getId(): Long { return id }
    fun getTitle(): String { return title }
    fun getContent(): String { return content }
    fun getStartDate(): Date { return startDate }
    fun getEndDate(): Date { return endDate }

}
