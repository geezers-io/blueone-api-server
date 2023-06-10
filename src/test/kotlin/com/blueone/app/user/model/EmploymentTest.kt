package com.blueone.app.user.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class EmploymentTest {

    @Test
    @DisplayName("id 를 getter 로 받아올 수 있다.")
    fun getter_id() {
        val emp = Employment(1, "000627")
        Assertions.assertThat(emp.getId()).isNotNull
    }

}