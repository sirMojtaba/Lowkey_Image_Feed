package com.example.lowkeyimagefeed.domain

import androidx.room.PrimaryKey

data class Src(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val large: String = "",
    val large2x: String = ""
)
