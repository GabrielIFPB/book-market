package com.inteligenciadigital.bookmarket.models


import org.hibernate.Hibernate
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "user")
data class User(
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

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
		other as User

		return id != null && id == other.id
	}

	override fun hashCode(): Int = javaClass.hashCode()

	@Override
	override fun toString(): String {
		return this::class.simpleName + "(id = $id , username = $username , email = $email , uid = $uid )"
	}
}