package com.inteligenciadigital.bookmarket.service

import com.inteligenciadigital.bookmarket.exception.CustomerNotFoundException
import com.inteligenciadigital.bookmarket.models.Customer
import com.inteligenciadigital.bookmarket.repository.CustomerRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class CustomerServiceImplements(var repository: CustomerRepository): CustomerService {

	override fun all(): List<Customer> =
		this.repository.findAll()

	override fun save(customer: Customer): Customer =
		this.repository.save(customer)

	override fun update(customer: Customer): Customer {
		TODO("Not yet implemented")
	}

	override fun delete(id: Long)  {
		throw CustomerNotFoundException("not found!")
	}

	override fun findById(id: Long): Customer {
		return Customer("", LocalDate.now())
	}
}