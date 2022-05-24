package com.inteligenciadigital.bookmarket.controllers

import com.inteligenciadigital.bookmarket.models.Customer
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.time.Month

@RestController
@RequestMapping("api/customers")
class CustomerController {

	@GetMapping("")
	fun findAll(): List<Customer> =
		arrayListOf(
			Customer("naruto", LocalDate.of(1989, Month.APRIL, 25)),
			Customer("Gohan", LocalDate.of(1989, Month.NOVEMBER, 25)),
		)

	@PostMapping("")
	fun save(@RequestBody data: Customer): Customer =
		Customer("Goku", LocalDate.of(1992, Month.JANUARY, 26))
}