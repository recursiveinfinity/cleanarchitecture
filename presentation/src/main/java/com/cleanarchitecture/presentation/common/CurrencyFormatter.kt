package com.cleanarchitecture.presentation.common

import java.text.NumberFormat
import java.util.*

class CurrencyFormatter {
    companion object {
        fun format(money: Double?, currency: Locale = Locale.UK): String =
                money?.let {
                    val format = NumberFormat.getCurrencyInstance()
                    format.currency = Currency.getInstance(currency)
                    format.format(money)
                } ?: ""
    }
}