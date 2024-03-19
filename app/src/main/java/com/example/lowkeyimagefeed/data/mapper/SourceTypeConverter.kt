package com.example.lowkeyimagefeed.data.mapper

import androidx.room.TypeConverter
import com.example.lowkeyimagefeed.domain.Src
import org.json.JSONObject

class SourceTypeConverter {

    @TypeConverter
    fun sourceToString(src: Src): String {
        return JSONObject().apply {
            put("id", src.id)
            put("large", src.large)
            put("large2x", src.large2x)
        }.toString()

    }

    @TypeConverter
    fun stringToSource(source: String): Src {
        val json = JSONObject(source)
        return Src(
            id = json.getInt("id"),
            large = json.getString("large"),
            large2x = json.getString("large2x")
        )
    }
}