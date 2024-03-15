package com.example.bookshelf.model

data class Book(
    val id: String,
    val volumeInfo: VolumeInfo
)

data class VolumeInfo(
    val title: String,
    val imageLinks: ImageLinks
)

data class ImageLinks(
    val thumbnail: String
)
