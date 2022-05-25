package com.inteligenciadigital.bookmarket.service

import com.inteligenciadigital.bookmarket.models.Customer

interface CustomerService {

	fun all(): List<Customer>

	fun save(customer: Customer): Customer

	fun update(customer: Customer): Customer

	fun delete(customer: Customer)

	fun findById(id: Long): Customer
}