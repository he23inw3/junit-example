package com.example.junitexample.service

import com.example.junitexample.entity.UserEntity
import com.example.junitexample.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
	private val userRepository: UserRepository
) {

	@Transactional(rollbackFor = [Exception::class])
	fun create(userList: List<UserEntity>, operatorId: String) {
		userRepository.create(userList, operatorId)
	}

	@Transactional(readOnly = true)
	fun fetchAll(userIdList: List<String>): List<UserEntity> {
		return userRepository.fetchAll(userIdList)
	}

	@Transactional(rollbackFor = [Exception::class])
	fun update(user: UserEntity, operatorId: String) {
		userRepository.update(user, operatorId)
	}

	@Transactional(rollbackFor = [Exception::class])
	fun delete(userId: String) {
		userRepository.delete(userId)
	}
}
