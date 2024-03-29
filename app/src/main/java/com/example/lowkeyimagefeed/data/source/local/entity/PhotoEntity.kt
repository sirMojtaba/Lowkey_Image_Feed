package com.example.lowkeyimagefeed.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.lowkeyimagefeed.domain.Src

@Entity(tableName = "photo_table")
data class PhotoEntity(
    @PrimaryKey
    val id: Int = 0,
    val photographer: String = "",
    val alt: String = "",
    val src: Src = Src()
)

