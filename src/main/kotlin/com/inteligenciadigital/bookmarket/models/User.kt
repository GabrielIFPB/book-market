package com.inteligenciadigital.bookmarket.models


import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "user")
class User(
	@Column(name = "name")
	var username: String,
	@Column(name = "email", unique = true)
	var email: String
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