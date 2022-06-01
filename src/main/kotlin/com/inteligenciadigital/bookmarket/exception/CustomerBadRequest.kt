package com.inteligenciadigital.bookmarket.exception

import org.springframework.context.MessageSourceResolvable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
class CustomerBadRequest: RuntimeException, MessageSourceResolvable {
	private val serialVersionUID = 1L

	constructor() : super() { }
	constructor(message: String) : super(message) { }
	constructor(cause: Throwable) : super(cause) { }
	constructor(message: String, cause: Throwable) : super(message, cause) { }

	override fun getCodes(): Array<String> = arrayOf("Customer: BAD REQUEST!")
	override fun getArguments(): Array<out Any> = arrayOf()
	override fun getDefaultMessage(): String?  = message
}