package com.inteligenciadigital.bookmarket.service

import com.inteligenciadigital.bookmarket.exception.CustomerBadRequest
import com.inteligenciadigital.bookmarket.exception.CustomerNotFoundException
import com.inteligenciadigital.bookmarket.models.Customer
import com.inteligenciadigital.bookmarket.repository.CustomerRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate


@Service
class CustomerServiceImplements(var repository: CustomerRepository): CustomerService {

	override fun all(): List<Customer> =
		this.repository.findAll()
    
	override fun save(customer: Customer): Customer =
		this.repository.save(customer)
    
	override fun update(customer: Customer): Customer =
		this.findById(customer.id).let {
			if (customer.uid != it.uid)
				throw CustomerBadRequest("not found uid: ${customer.uid}")
			return this.repository.save(customer)
		}

	@Transactional
	override fun updateBirthdate(id: Long, birthdate: LocalDate): Int =
		this.findById(id).let {
			this.repository.updateBirthdate(id, birthdate)
		}
  
	override fun delete(id: Long): Unit =
		this.repository.delete(this.findById(id))

	override fun findById(id: Long): Customer {
		val customer = repository.findById(id)
		return customer.orElseThrow { CustomerNotFoundException("NOT_FOUND...") }
	}
}