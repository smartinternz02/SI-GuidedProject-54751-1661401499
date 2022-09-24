package com.example.nigerianlunchtray.data

import com.example.nigerianlunchtray.constants.ItemType
import com.example.nigerianlunchtray.model.MenuItem

/**
 * All items on the menu
 */
object DataSource {
    val menuItems = mapOf(
        "eba" to MenuItem(
            name = "Eba",
            price = 500.00,
            type = ItemType.MAIN,
        ),
        "fried_rice" to MenuItem(
            name = "Fried Rice",
            price = 800.00,
            type = ItemType.MAIN,
        ),
        "jollof_rice" to MenuItem(
            name = "Jollof Rice",
            price = 700.00,
            type = ItemType.MAIN,
        ),
        "pounded_yam" to MenuItem(
            name = "Pounded Yam",
            price = 600.00,
            type = ItemType.MAIN,
        ),
        "rice_and_beans" to MenuItem(
            name = "Rice and Beans",
            price = 800.00,
            type = ItemType.MAIN,
        ),
        "white_rice" to MenuItem(
            name = "White Rice",
            price = 500.00,
            type = ItemType.MAIN,
        ),
        "black_soup" to MenuItem(
            name = "Black Soup",
            price = 500.00,
            type = ItemType.SOUP,
        ),
        "egusi_soup" to MenuItem(
            name = "Egusi Soup",
            price = 500.00,
            type = ItemType.SOUP,
        ),
        "ogbono_soup" to MenuItem(
            name = "Ogbono Soup",
            price = 500.00,
            type = ItemType.SOUP,
        ),
        "tomato_stew" to MenuItem(
            name = "Tomato Stew",
            price = 200.00,
            type = ItemType.SOUP,
        ),
        "fried_beef" to MenuItem(
            name = "Fried Beef",
            price = 500.00,
            type = ItemType.MEAT,
        ),
        "fried_chicken" to MenuItem(
            name = "Fried Chicken",
            price = 800.00,
            type = ItemType.MEAT,
        ),
        "fried_fish" to MenuItem(
            name = "Fried Fish",
            price = 600.00,
            type = ItemType.MEAT,
        ),
        "fried_goat_meat" to MenuItem(
            name = "Fried Goat Meat",
            price = 600.00,
            type = ItemType.MEAT,
        ),
        "roasted_beef" to MenuItem(
            name = "Roasted Beef",
            price = 700.00,
            type = ItemType.MEAT,
        ),
        "roasted_chicken" to MenuItem(
            name = "Roasted Chicken",
            price = 1000.00,
            type = ItemType.MEAT,
        ),
        "assorted_meat_pepper_soup" to MenuItem(
            name = "Assorted Meat Pepper Soup",
            price = 1000.00,
            type = ItemType.SIDE,
        ),
        "catfish_pepper_soup" to MenuItem(
            name = "Catfish Pepper Soup",
            price = 1000.00,
            type = ItemType.SIDE,
        ),
        "dodo" to MenuItem(
            name = "Dodo",
            price = 300.00,
            type = ItemType.SIDE,
        ),
        "goat_meat_pepper_soup" to MenuItem(
            name = "Goat Meat Pepper Soup",
            price = 1000.00,
            type = ItemType.SIDE,
        ),
        "moin_moin" to MenuItem(
            name = "Moin Moin",
            price = 300.00,
            type = ItemType.SIDE,
        ),
        "salad" to MenuItem(
            name = "Salad",
            price = 500.00,
            type = ItemType.SIDE,
        ),
        "apple_juice" to MenuItem(
            name = "Apple Juice",
            price = 300.00,
            type = ItemType.DRINK,
        ),
        "coke" to MenuItem(
            name = "Coke",
            price = 200.00,
            type = ItemType.DRINK,
        ),
        "fanta" to MenuItem(
            name = "Fanta",
            price = 200.00,
            type = ItemType.DRINK,
        ),
        "orange_juice" to MenuItem(
            name = "Orange Juice",
            price = 300.00,
            type = ItemType.DRINK,
        ),
        "sprite" to MenuItem(
            name = "Sprite",
            price = 200.00,
            type = ItemType.DRINK,
        ),
        "water" to MenuItem(
            name = "Water",
            price = 100.00,
            type = ItemType.DRINK,
        ),
    )
}
