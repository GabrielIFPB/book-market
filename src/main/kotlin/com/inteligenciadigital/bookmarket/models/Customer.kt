package com.inteligenciadigital.bookmarket.models

import org.hibernate.Hibernate
import java.time.LocalDate
import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "customer")
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

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
		other as Customer

		return id != null && id == other.id
	}

	override fun hashCode(): Int = javaClass.hashCode()

	@Override
	override fun toString(): String {
		return this::class.simpleName + "(id = $id , name = $name , birthdate = $birthdate , uid = $uid )"
	}
}