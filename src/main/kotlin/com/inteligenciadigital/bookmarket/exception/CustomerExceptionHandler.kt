package com.inteligenciadigital.bookmarket.exception

import com.inteligenciadigital.bookmarket.models.ModelException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.sql.Timestamp


@ControllerAdvice
class CustomerExceptionHandler: ResponseEntityExceptionHandler() {

	@ExceptionHandler(value = [CustomerNotFoundException::class])
	fun correntistaBadRequest(e: CustomerNotFoundException): ResponseEntity<Any?>? =
		ResponseEntity(
			this.constructHandlerException(e),
			HttpStatus.NOT_FOUND
		)

	private fun constructHandlerException(e: RuntimeException): ModelException =
		ModelException.Builder()
			.message(e.message.toString())
			.httpStatus(HttpStatus.NOT_FOUND)
			.status(HttpStatus.NOT_FOUND.value())
			.timestamp(Timestamp(System.currentTimeMillis()))
			.build()
}