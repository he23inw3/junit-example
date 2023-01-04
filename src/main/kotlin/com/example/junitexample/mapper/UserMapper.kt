package com.example.junitexample.mapper

import com.example.junitexample.mapper.model.UserRecord
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

@Mapper
interface UserMapper {
	fun selectAll(@Param("userIdList") userIdList: List<String>): List<UserRecord>

	fun bulkInsert(@Param("userList") userList: List<UserRecord>)

	fun update(@Param("user") user: UserRecord)

	fun delete(@Param("userId") userId: String)
}
