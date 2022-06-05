package com.inteligenciadigital.bookmarket.service

import com.inteligenciadigital.bookmarket.models.Customer
import java.time.LocalDate

interface CustomerService {

	fun all(): List<Customer>

	fun save(customer: Customer): Customer

	fun update(customer: Customer): Customer

	fun updateBirthdate(id: Long, birthdate: LocalDate): Int

	fun updateName(id: Long, name: String): Int

	fun delete(id: Long)

	fun findById(id: Long): Customer
}