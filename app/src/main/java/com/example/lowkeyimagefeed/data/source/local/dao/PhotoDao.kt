package com.example.lowkeyimagefeed.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.lowkeyimagefeed.data.source.local.entity.PhotoEntity

@Dao
interface PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhoto(photo: PhotoEntity)

    @Delete
    fun deletePhoto(photo: PhotoEntity)

    @Update
    fun updatePhoto(photo: PhotoEntity)

    @Query("select * from photo_table")
    fun readAllPhotos(): List<PhotoEntity>

    @Query("DELETE FROM photo_table")
    fun deleteAll()

}