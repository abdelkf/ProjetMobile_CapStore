package com.capStore.util

import com.capStore.model.Product


interface MyIterator<T> {
    fun hasNext(): Boolean
    fun next(): T
}

interface MyIterableCollection<T> {
    fun createIterator(): MyIterator<T>
}

class ProductCollection(private val products: List<Product>) : MyIterableCollection<Product> {

    override fun createIterator(): MyIterator<Product> {
        return ProductIterator(products)
    }

    class ProductIterator(private val products: List<Product>) : MyIterator<Product> {
        private var index = 0

        override fun hasNext(): Boolean = index < products.size

        override fun next(): Product = products[index++]
    }
}