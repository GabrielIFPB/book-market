package com.inteligenciadigital.bookmarket.controllers

import com.inteligenciadigital.bookmarket.models.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("api/users")
class UserController {

	@GetMapping("")
	fun users(): User = User("gabriel", "gabriel@email.com")

	@GetMapping("/{uuid}")
	fun users(@PathVariable uuid: String): User {
		return User("gabriel", "gabriel@email.com")
	}
}