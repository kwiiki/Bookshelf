package com.example.bookshelf.ui.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookshelf.data.BookRepository
import com.example.bookshelf.model.Book
import kotlinx.coroutines.launch

class BookViewModel(private val repository: BookRepository) : ViewModel() {
    private val _books = mutableStateOf<List<Book>>(emptyList())
    val books: State<List<Book>> = _books

    fun searchBooks(query: String) {
        viewModelScope.launch {
            val result = repository.getBooks(query)
            _books.value = result
        }
    }
}