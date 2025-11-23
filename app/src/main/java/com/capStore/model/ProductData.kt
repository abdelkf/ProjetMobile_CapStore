package com.capStore.model

import com.capStore.R

object ProductData {
    val products = listOf(
        Product(
            id = 1,
            name = "Classic Baseball Cap",
            price = 25.0,
            label = "New",
            imageRes = R.drawable.cap1
        ),
        Product(
            id = 2,
            name = "Trucker Hat",
            price = 20.0,
            label = "Sale",
            imageRes = R.drawable.cap2
        ),
        Product(
            id = 3,
            name = "Snapback Cap",
            price = 30.0,
            label = null,
            imageRes = R.drawable.cap3
        ),
        Product(
            id = 4,
            name = "Dad Hat",
            price = 18.0,
            label = null,
            imageRes = R.drawable.cap4
        )
    )
}
