package com.inteligenciadigital.bookmarket.controllers

import com.inteligenciadigital.bookmarket.models.Customer
import com.inteligenciadigital.bookmarket.service.CustomerServiceImplements
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.time.Month

@RestController
@RequestMapping("api/customers")
class CustomerController(var service: CustomerServiceImplements) {

	@GetMapping("")
	fun findAll(): List<Customer> = this.service.all()


	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	fun save(@RequestBody customer: Customer): Customer =
		this.service.save(customer)
}