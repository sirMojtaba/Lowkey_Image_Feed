package com.example.lowkeyimagefeed.domain

data class Photo(
    val id: Int = 0,
    val photographer: String = "",
    val src: Src = Src()
)
