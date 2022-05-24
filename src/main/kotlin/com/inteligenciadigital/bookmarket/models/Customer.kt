package com.inteligenciadigital.bookmarket.models

import java.time.LocalDate
import java.util.UUID
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

data class Customer(
	@Column(name = "name", length = 64, nullable = false)
	var name: String,

	@Column(name = "birthdate")
	var birthdate: LocalDate
) {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	var id: Long? = null

	@Column(name = "uid", unique = true)
	var uid: String = ""

	init {
		val uid: UUID = UUID.randomUUID()
		this.uid = this.uid.ifEmpty { uid.toString() }
	}
}