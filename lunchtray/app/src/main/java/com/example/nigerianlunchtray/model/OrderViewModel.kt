package com.example.nigerianlunchtray.model

import android.view.View
import android.widget.CheckBox
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.nigerianlunchtray.data.DataSource
import java.text.NumberFormat
import java.util.*

class OrderViewModel : ViewModel() {
    // Map of menu items
    val menuItems = DataSource.menuItems

    // Default values for item prices
    private var _previousMainPrice = 0.0
    private var _previousSoupPrice = 0.0
    private var _previousMeatPrice = 0.0
    private var _previousSidePrice = 0.0
    private var _previousDrinkPrice = 0.0

    // Default tax rate
    private val _taxRate = 0.1

    // Main for the order
    private val _main = MutableLiveData<MenuItem?>()
    val main: LiveData<MenuItem?> = _main

    // Soup for the order
    private val _soup = MutableLiveData<MenuItem?>()
    val soup: LiveData<MenuItem?> = _soup

    // Meat for the order
    private val _meat = MutableLiveData<List<MenuItem?>?>()
    val meat: LiveData<List<MenuItem?>?> = _meat

    // Side for the order
    private val _side = MutableLiveData<List<MenuItem?>?>()
    val side: LiveData<List<MenuItem?>?> = _side

    // Drink for the order
    private val _drink = MutableLiveData<List<MenuItem?>?>()
    val drink: LiveData<List<MenuItem?>?> = _drink

    // Subtotal for the order
    private val _subtotal = MutableLiveData(0.0)
    val subtotal: LiveData<String> = Transformations.map(_subtotal) {
        NumberFormat.getCurrencyInstance(Locale("en", "NG")).format(it)
    }

    // Total cost of the order
    private val _total = MutableLiveData(0.0)
    val total: LiveData<String> = Transformations.map(_total) {
        NumberFormat.getCurrencyInstance(Locale("en", "NG")).format(it)
    }

    // Tax for the order
    private val _tax = MutableLiveData(0.0)
    val tax: LiveData<String> = Transformations.map(_tax) {
        NumberFormat.getCurrencyInstance(Locale("en", "NG")).format(it)
    }

    /**
     * Set the main for the order.
     */
    fun setMain(main: String) {
        if (_main.value != null) {
            _previousMainPrice = _main.value!!.price
        }

        if (_subtotal.value != null) {
            _subtotal.value = _subtotal.value!! - _previousMainPrice
        }

        _main.value = menuItems[main]
        updateSubtotal(_main.value!!.price)
    }

    /**
     * Set the soup for the order.
     */
    fun setSoup(soup: String) {
        if (_soup.value != null) {
            _previousSoupPrice = _soup.value!!.price
        }

        if (_subtotal.value != null) {
            _subtotal.value = _subtotal.value!! - _previousSoupPrice
        }

        _soup.value = menuItems[soup]
        updateSubtotal(_soup.value!!.price)
    }

    /**
     * Set the meat for the order.
     */
    fun setMeat(view: View, meat: String) {
        if (view is CheckBox) {
            // Mutable list used to modify list of meats
            val tempMeatList = mutableListOf<MenuItem?>()

            // Copy previous list of meats to tempMeatList
            _meat.value?.let { tempMeatList.addAll(it) }

            // Determine if the checkbox is checked or not
            val checked: Boolean = view.isChecked
            if (checked) {
                tempMeatList.add(menuItems[meat])
                _meat.value = tempMeatList.toList()
                _previousMeatPrice = menuItems[meat]!!.price
            } else {
                tempMeatList.remove(menuItems[meat])
                _meat.value = tempMeatList.toList()
                _previousMeatPrice = -(menuItems[meat]!!.price)
            }

            updateSubtotal(_previousMeatPrice)
        }
    }

    /**
     * Set the side for the order.
     */
    fun setSide(view: View, side: String) {
        if (view is CheckBox) {
            // Mutable list used to modify list of sides
            val tempSideList = mutableListOf<MenuItem?>()

            // Copy previous list of sides to tempSideList
            _side.value?.let { tempSideList.addAll(it) }

            // Determine if the checkbox is checked or not
            val checked: Boolean = view.isChecked
            if (checked) {
                tempSideList.add(menuItems[side])
                _side.value = tempSideList.toList()
                _previousSidePrice = menuItems[side]!!.price
            } else {
                tempSideList.remove(menuItems[side])
                _side.value = tempSideList.toList()
                _previousSidePrice = -(menuItems[side]!!.price)
            }

            updateSubtotal(_previousSidePrice)
        }
    }

    /**
     * Set the drink for the order.
     */
    fun setDrink(view: View, drink: String) {
        if (view is CheckBox) {
            // Mutable list used to modify list of drinks
            val tempDrinkList = mutableListOf<MenuItem?>()

            // Copy previous list of drinks to tempDrinkList
            _drink.value?.let { tempDrinkList.addAll(it) }

            // Determine if the checkbox is checked or not
            val checked: Boolean = view.isChecked
            if (checked) {
                tempDrinkList.add(menuItems[drink])
                _drink.value = tempDrinkList.toList()
                _previousDrinkPrice = menuItems[drink]!!.price
            } else {
                tempDrinkList.remove(menuItems[drink])
                _drink.value = tempDrinkList.toList()
                _previousDrinkPrice = -(menuItems[drink]!!.price)
            }

            updateSubtotal(_previousDrinkPrice)
        }
    }

    /**
     * Update subtotal value.
     */
    private fun updateSubtotal(itemPrice: Double) {
        if (_subtotal.value != null) {
            _subtotal.value = _subtotal.value!! + itemPrice
        } else {
            _subtotal.value = itemPrice
        }

        // Calculate the tax and resulting total
        calculateTaxAndTotal()
    }

    /**
     * Calculate tax and update total.
     */
    private fun calculateTaxAndTotal() {
        _tax.value = _subtotal.value?.times(_taxRate)
        _total.value = _subtotal.value?.plus(_tax.value!!)
    }

    /**
     * Reset all values pertaining to the order.
     */
    fun resetOrder() {
        _previousMainPrice = 0.0
        _previousSoupPrice = 0.0
        _previousMeatPrice = 0.0
        _previousSidePrice = 0.0
        _previousDrinkPrice = 0.0
        _main.value = null
        _soup.value = null
        _meat.value = null
        _side.value = null
        _drink.value = null
        _subtotal.value = 0.0
        _total.value = 0.0
        _tax.value = 0.0
    }
}
