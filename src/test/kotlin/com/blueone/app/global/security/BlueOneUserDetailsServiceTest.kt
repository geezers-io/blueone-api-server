package com.blueone.app.global.security

import com.blueone.app.global.jpa.CreateUpdateDateSet
import com.blueone.app.user.exception.UserNotFoundException
import com.blueone.app.user.model.User
import com.blueone.app.user.service.UserRole
import com.blueone.app.user.service.UserRoleConverter
import jakarta.persistence.EntityManager
import jakarta.transaction.Transactional
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate

@SpringBootTest
@Transactional
class BlueOneUserDetailsServiceTest {

    @Autowired
    lateinit var entityManager: EntityManager

    @Autowired
    lateinit var userDetailsService: BlueOneUserDetailsService

    var userId: String? = null

    @BeforeEach
    fun create_test_user_before() {
        val now = LocalDate.now()
        val testUser = User(
            role = UserRoleConverter().deserialize(UserRole.USER),
            phone = "01012341234",
            password = "ay1clsllclcls",
            createUpdateDateSet = CreateUpdateDateSet(createdDate = now, updatedDate = now)
        )
        entityManager.persist(testUser)
        userId = testUser.id.toString()
    }

    @Test
    @DisplayName("loadUserByUsername 에서 성공적으로 User 를 불러서 UserDetails 객체로 반환한다.")
    fun get_test_user_by_load_user_by_username() {
        val userDetails = userDetailsService.loadUserByUsername(userId as String)
        Assertions.assertInstanceOf(BlueOneUserDetails::class.java, userDetails)
    }

    @Test
    @DisplayName("loadUserById 에서 성공적으로 User 를 불러서 UserDetails 객체로 반환한다.")
    fun get_test_user_by_load_user_by_id() {
        val userDetails = userDetailsService.loadUserById(userId!!.toLong())
        Assertions.assertInstanceOf(BlueOneUserDetails::class.java, userDetails)
    }

    @Test
    @DisplayName("없는 사용자를 불러왔을 때 UserNotFoundException 이 발생한다.")
    fun except_non_user() {
        Assertions.assertThrows(UserNotFoundException::class.java) {
            userDetailsService.loadUserByUsername("9999994")
        }
    }

}
