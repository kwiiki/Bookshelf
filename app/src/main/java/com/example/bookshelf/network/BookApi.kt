package com.example.bookshelf.network

import com.example.bookshelf.model.Book
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApi {
    @GET("volumes")
    suspend fun getBooks(@Query("q") query: String): Response<BookResponse>
}

data class BookResponse(
    val items: List<Book>
)