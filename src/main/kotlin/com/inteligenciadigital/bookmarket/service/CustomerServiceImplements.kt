package com.inteligenciadigital.bookmarket.service

import com.inteligenciadigital.bookmarket.exception.CustomerNotFoundException
import com.inteligenciadigital.bookmarket.models.Customer
import com.inteligenciadigital.bookmarket.repository.CustomerRepository
import org.springframework.stereotype.Service


@Service
class CustomerServiceImplements(var repository: CustomerRepository): CustomerService {

	override fun all(): List<Customer> =
		this.repository.findAll()

    
	override fun save(customer: Customer): Customer =
		this.repository.save(customer)

    
	override fun update(customer: Customer): Customer {
		this.findById(customer.id)
		return this.repository.save(customer)
	}

  
	override fun delete(id: Long): Unit =
		this.repository.delete(this.findById(id))

	override fun findById(id: Long): Customer {
		val o = repository.findById(id)
		return o.orElseThrow { CustomerNotFoundException("NOT_FOUND...") }
	}
}