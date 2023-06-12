package com.blueone.app.global.jpa

import jakarta.persistence.Embeddable
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate

import java.util.Date
@Embeddable
data class CreateUpdateDateSet(
    @CreatedDate
    var createdDate: Date,
    @LastModifiedDate
    var updatedDate: Date
)
