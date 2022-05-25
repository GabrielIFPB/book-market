package com.inteligenciadigital.bookmarket.service

import com.inteligenciadigital.bookmarket.models.Customer
import com.inteligenciadigital.bookmarket.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerServiceImplements(var repository: CustomerRepository): CustomerService {

	override fun all(): List<Customer> {
		return this.repository.findAll()
	}

	override fun save(customer: Customer): Customer {
		return this.repository.save(customer)
	}

	override fun update(customer: Customer): Customer {
		TODO("Not yet implemented")
	}

	override fun delete(customer: Customer) {
		TODO("Not yet implemented")
	}

	override fun findById(id: Long): Customer {
		TODO("Not yet implemented")
	}
}