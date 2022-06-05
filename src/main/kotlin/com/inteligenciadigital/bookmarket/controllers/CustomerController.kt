package com.inteligenciadigital.bookmarket.controllers

import com.inteligenciadigital.bookmarket.exception.CustomerBadRequest
import com.inteligenciadigital.bookmarket.exception.CustomerNotFoundException
import com.inteligenciadigital.bookmarket.models.Customer
import com.inteligenciadigital.bookmarket.models.CustomerBirthdate
import com.inteligenciadigital.bookmarket.models.CustomerName
import com.inteligenciadigital.bookmarket.service.CustomerServiceImplements
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("api/customers")
class CustomerController(var service: CustomerServiceImplements) {

	@GetMapping("")
	fun findAll(): List<Customer> = this.service.all()

	@GetMapping("/{id}")
	fun findById(@PathVariable id: Long): Customer =
		try {
			this.service.findById(id)
		} catch (e: CustomerNotFoundException) {
			throw CustomerNotFoundException("Não encontrado...")
		}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	fun save(@RequestBody customer: Customer): Customer =
		this.service.save(customer)

	@PutMapping("")
	@ResponseStatus(HttpStatus.OK)
	fun update(@RequestBody customer: Customer): Customer =
		try {
			this.service.update(customer)
		} catch (e: CustomerNotFoundException) {
			throw CustomerNotFoundException("não encontrado")
		} catch (e: CustomerBadRequest) {
			throw CustomerBadRequest(e.message.toString())
		}

	@PatchMapping("/{id}/birthdate")
	@ResponseStatus(HttpStatus.OK)
	fun updateBirthdate(
			@PathVariable id: Long,
				@RequestBody customerRequest: CustomerBirthdate): Int =
		try {
			this.service.updateBirthdate(
				id, customerRequest.birthdate
			)
		} catch (e: CustomerNotFoundException) {
			throw CustomerNotFoundException("Customer ${id}: not found!")
		}

	@PatchMapping("/{id}/name")
	@ResponseStatus(HttpStatus.OK)
	fun updateName(
			@PathVariable id: Long,
				@RequestBody customerRequest: CustomerName): Int =
		try {
			this.service.updateName(id, customerRequest.name)
		} catch (e: CustomerNotFoundException) {
			throw CustomerNotFoundException("Customer ${id}: not found!")
		}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	fun delete(@PathVariable id: Long): Unit =
		try {
			this.service.delete(id)
		} catch (e: CustomerNotFoundException) {
			throw CustomerNotFoundException("Customer: not found!")
		}
}