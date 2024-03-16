package com.example.lowkeyimagefeed.domain

data class Photos(
    val page: Int = 0,
    val perPage: Int = 0,
    val photos: List<Photo> = emptyList(),
    val totalResults: Int = 0,
    val nextPage: String = ""
)
