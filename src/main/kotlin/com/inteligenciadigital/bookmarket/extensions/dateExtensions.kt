package com.inteligenciadigital.bookmarket.extensions

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField
import java.util.*


/**
 * @author: Jerônimo Gabriel da Silva
 * @param: dateString format 0000-00-00 year-month-dayOfMonth
 * @return: LocalDate
 */
fun convertStringForLocalDate(dateString: String): LocalDate {
	val data = dateString.split("-").map { it.trim().toInt() }
	return LocalDate.of(data[0], data[1], data[2])
}

fun LocalDateTime.format(): String = this.format(englishDateFormatter)

private val daysLookup = (1..31).associate { it.toLong() to getOrdinal(it) }

private val englishDateFormatter = DateTimeFormatterBuilder()
	.appendPattern("yyyy-MM-dd")
	.appendLiteral(" ")
	.appendText(ChronoField.DAY_OF_MONTH, daysLookup)
	.appendLiteral(" ")
	.appendPattern("yyyy")
	.toFormatter(Locale.ENGLISH)

private fun getOrdinal(n: Int) = when {
	n in 11..13 -> "${n}th"
	n % 10 == 1 -> "${n}st"
	n % 10 == 2 -> "${n}nd"
	n % 10 == 3 -> "${n}rd"
	else -> "${n}th"
}