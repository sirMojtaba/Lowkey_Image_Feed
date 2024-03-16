package com.example.lowkeyimagefeed.domain

data class RequestPhotos(
    val page: Int = 1,
    val perPage: Int = 15
)
