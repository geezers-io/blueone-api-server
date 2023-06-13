package com.blueone.app.global.jpa

import jakarta.persistence.Embeddable
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDate

@Embeddable
data class CreateUpdateDateSet(
    @CreatedDate
    var createdDate: LocalDate,
    @LastModifiedDate
    var updatedDate: LocalDate
)
