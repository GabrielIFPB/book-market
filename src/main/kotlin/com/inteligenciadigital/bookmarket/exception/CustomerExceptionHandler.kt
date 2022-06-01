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
	fun customerNotFoundException(e: CustomerNotFoundException): ResponseEntity<Any?>? =
		ResponseEntity(
			this.constructHandlerException(e, HttpStatus.NOT_FOUND),
			HttpStatus.NOT_FOUND
		)

	@ExceptionHandler(value = [CustomerBadRequest::class])
	fun customerBadRequestException(e: CustomerBadRequest): ResponseEntity<Any?>? =
		ResponseEntity(
			this.constructHandlerException(e, HttpStatus.BAD_REQUEST),
			HttpStatus.BAD_REQUEST
		)

	private fun constructHandlerException
				(e: RuntimeException, httpStatus: HttpStatus): ModelException =
		ModelException.Builder()
			.message(e.message.toString())
			.httpStatus(httpStatus)
			.status(httpStatus.value())
			.timestamp(Timestamp(System.currentTimeMillis()))
			.build()
}