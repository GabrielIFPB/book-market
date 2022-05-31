package com.inteligenciadigital.bookmarket.controllers

import com.inteligenciadigital.bookmarket.exception.CustomerNotFoundException
import com.inteligenciadigital.bookmarket.models.Customer
import com.inteligenciadigital.bookmarket.service.CustomerServiceImplements
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("api/customers")
class CustomerController(var service: CustomerServiceImplements) {

	@GetMapping("")
	fun findAll(): List<Customer> = this.service.all()


	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	fun save(@RequestBody customer: Customer): Customer =
		this.service.save(customer)

	
	@DeleteMapping("/{id}")
	fun delete(@PathVariable id: Long): Unit =
		try {
			this.service.delete(id)
		} catch (e: CustomerNotFoundException) {
			throw CustomerNotFoundException("Customer: not found!")
		}
}