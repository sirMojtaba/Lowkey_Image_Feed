package com.example.lowkeyimagefeed.domain

import java.io.Serializable

data class Photo(
    val id: Int = 0,
    val photographer: String = "",
    val src: Src = Src()
) : Serializable
