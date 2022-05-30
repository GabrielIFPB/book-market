package com.inteligenciadigital.bookmarket.models

import org.springframework.http.HttpStatus
import java.sql.Timestamp

class ModelException private constructor(
	var message: String? = null,
	var httpStatus: HttpStatus? = null,
	var status: Int = 0,
	var timestamp: Timestamp? = null
) {
	data class Builder(
		var message: String? = null,
		var httpStatus: HttpStatus? = null,
		var status: Int = 0,
		var timestamp: Timestamp? = null) {

		fun message(message: String) = apply { this.message = message }
		fun httpStatus(httpStatus: HttpStatus) = apply { this.httpStatus = httpStatus }
		fun status(status: Int) = apply { this.status = status }
		fun timestamp(timestamp: Timestamp) = apply { this.timestamp = timestamp }
		fun build() = ModelException(message, httpStatus, status, timestamp)
	}
}