package com.example.lowkeyimagefeed.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.lowkeyimagefeed.data.source.local.entity.PhotoEntity

@Dao
interface PhotoDao {

    @Upsert
    fun upsertPhoto(photos: List<PhotoEntity>)

    @Query("select * from photo_table")
    fun readAllPhotos(): List<PhotoEntity>
}