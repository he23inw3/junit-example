package com.example.junitexample.mapper.model

import java.time.LocalDateTime

data class UserRecord(
	val id: String,
	val name: String? = null,
	val age: Int? = null,
	val emailAddress: String? = null,
	val createdBy: String? = null,
	val createdAt: LocalDateTime? = null,
	val updatedBy: String? = null,
	val updatedAt: LocalDateTime? = null
)
