package com.example.junitexample.service

import com.example.junitexample.entity.UserEntity
import com.example.junitexample.repository.UserRepository
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@ExtendWith(MockKExtension::class)
class UserServiceTest {

	@InjectMockKs
	private lateinit var testSuite: UserService

	@MockK
	private lateinit var userRepository: UserRepository

	@Nested
	@DisplayName("Create系試験")
	inner class Create {

		@Test
		@DisplayName("createでユーザ登録が行えるか確認")
		fun create_case1() {
			// setup
			val u001Entity = UserEntity(id = "U001", name = "USER0001", age = 20, emailAddress = "test@dmm.co.jp")
			every { userRepository.create(listOf(u001Entity), "junit") } returns Unit

			// execute
			testSuite.create(listOf(u001Entity), "junit")

			// verify
			verify { userRepository.create(listOf(u001Entity), "junit") }
		}
	}

	@Nested
	@DisplayName("FetchAll系試験")
	inner class FetchAll {

		@Test
		@DisplayName("fetchAllで対象ユーザを取得できるか確認")
		fun fetchAll_case1() {
			// setup
			val u002Entity = UserEntity(id = "U002", name = "USER0002", age = 20, emailAddress = "test@dmm.co.jp")
			every { userRepository.fetchAll(listOf("U002")) } returns listOf(u002Entity)

			// execute
			val actual = testSuite.fetchAll(listOf("U002"))

			// verify
			val expected = listOf(u002Entity)
			assertEquals(expected, actual)
			verify { userRepository.fetchAll(listOf("U002")) }
		}
	}

	@Nested
	@DisplayName("Update系試験")
	inner class Update {

		@Test
		@DisplayName("updateで対象ユーザを更新できるか確認")
		fun update_case1() {
			// setup
			val u003Entity = UserEntity(id = "U002", name = "USER0002", age = 20, emailAddress = "test@dmm.co.jp")
			every { userRepository.update(u003Entity, "junit") } returns Unit

			// execute
			testSuite.update(u003Entity, "junit")

			// verify
			verify { userRepository.update(u003Entity, "junit") }
		}
	}

	@Nested
	@DisplayName("Delete系試験")
	inner class Delete {

		@Test
		@DisplayName("deleteで対象ユーザを削除できるか確認")
		fun delete_case1() {
			// setup
			every { userRepository.delete("U004") } returns Unit

			// execute
			testSuite.delete("U004")

			// verify
			verify { userRepository.delete("U004") }
		}
	}
}
