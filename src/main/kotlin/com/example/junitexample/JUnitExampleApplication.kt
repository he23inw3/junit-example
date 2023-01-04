package com.example.junitexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DockerTestApplication

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
	runApplication<DockerTestApplication>(*args)
}
