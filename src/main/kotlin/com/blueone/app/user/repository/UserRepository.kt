package com.blueone.app.user.repository

import com.blueone.app.user.model.QUser.user
import com.blueone.app.user.model.User
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
class UserRepository(
    private val jpaQueryFactory: JPAQueryFactory
) {

    fun findById(userId: Long): Optional<User> {
        val user = jpaQueryFactory.selectFrom(user)
                .where(user.id.eq(userId))
                .fetchOne()
        return Optional.ofNullable(user)
    }

}
