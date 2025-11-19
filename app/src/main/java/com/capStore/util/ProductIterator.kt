package com.capStore.util


class ProductIterator(private val products: List<String>) : Iterator<String> {
    private var index = 0

    override fun hasNext(): Boolean = index < products.size

    override fun next(): String {
        if (!hasNext()) throw NoSuchElementException()
        return products[index++]
    }
}
