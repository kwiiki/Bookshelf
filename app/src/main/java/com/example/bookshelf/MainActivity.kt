package com.example.bookshelf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bookshelf.data.BookRepository
import com.example.bookshelf.network.BookApi
import com.example.bookshelf.ui.screens.BookViewModel
import com.example.bookshelf.ui.screens.BookshelfScreen
import com.example.bookshelf.ui.theme.BookshelfTheme
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/books/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val bookApi = retrofit.create(BookApi::class.java)
            val bookRepository = BookRepository(bookApi)
            val bookViewModel = BookViewModel(bookRepository)

            setContent {
                BookshelfScreen(viewModel = bookViewModel)
            }

        }
    }
}
