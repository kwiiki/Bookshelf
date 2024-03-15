package com.example.bookshelf.data

import com.example.bookshelf.model.Book
import com.example.bookshelf.network.BookApi

class BookRepository(private val api: BookApi) {
    suspend fun getBooks(query: String): List<Book> {
        val response = api.getBooks(query)
        return if (response.isSuccessful) {
            response.body()?.items ?: emptyList()
        } else {
            emptyList()
        }
    }
}