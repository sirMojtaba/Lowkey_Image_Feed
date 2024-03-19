package com.example.lowkeyimagefeed.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.lowkeyimagefeed.data.mapper.SourceTypeConverter
import com.example.lowkeyimagefeed.data.source.local.dao.PhotoDao
import com.example.lowkeyimagefeed.data.source.local.entity.PhotoEntity

@Database(entities = [PhotoEntity::class], version = 1, exportSchema = false)
@TypeConverters(SourceTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract val photoDao: PhotoDao

    companion object {
        const val DB_NAME = "LowKeyImageFeedDatabase.db"
    }
}