package com.inteligenciadigital.bookmarket.controllers

import com.inteligenciadigital.bookmarket.models.Customer
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("api/customers")
class CustomerController {

	@GetMapping("")
	fun findAll(): Customer =
		Customer("naruto", LocalDate.of(1989, 4, 25))

	@PostMapping("")
	fun save(@RequestBody data: Customer): Customer =
		Customer("Goku", LocalDate.of(1992, 1, 26))
}