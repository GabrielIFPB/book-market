package com.inteligenciadigital.bookmarket.repository

import com.inteligenciadigital.bookmarket.models.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: JpaRepository<Customer, Long> {
}