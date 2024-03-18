package com.example.lowkeyimagefeed.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "src_table")
data class SrcEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val large: String = "",
    val large2x: String = ""
)

