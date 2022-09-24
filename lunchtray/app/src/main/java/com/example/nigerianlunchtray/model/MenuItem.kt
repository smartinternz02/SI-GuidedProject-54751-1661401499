package com.example.nigerianlunchtray.model

import java.text.NumberFormat
import java.util.*

/**
 * Features of items on the menu
 */
data class MenuItem(
    val name: String,
    val price: Double,
    val type: Int,
) {
    /**
     * Get price formatted in specified currency (Nigerian naira)
     */
    fun getFormattedPrice(): String =
        NumberFormat.getCurrencyInstance(Locale("en", "NG")).format(price)
}