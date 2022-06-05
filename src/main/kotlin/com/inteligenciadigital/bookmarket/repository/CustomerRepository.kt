package com.inteligenciadigital.bookmarket.repository

import com.inteligenciadigital.bookmarket.models.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
interface CustomerRepository: JpaRepository<Customer, Long> {

	@Modifying
	@Query("UPDATE Customer c set c.birthdate = :birthdate WHERE c.id = :id")
	fun updateBirthdate(@Param("id") id: Long, @Param("birthdate") birthdate: LocalDate): Int

	@Modifying
	@Query("UPDATE Customer c set c.name = :name WHERE c.id = :id")
	fun updateName(@Param("id") id: Long, @Param("name") name: String): Int

}