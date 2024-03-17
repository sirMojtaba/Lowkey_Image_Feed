package com.example.lowkeyimagefeed.domain

import com.google.gson.annotations.SerializedName

data class PhotosResponse(
    val page: Int = 0,
    @SerializedName("per_page")
    val perPage: Int = 0,
    val photos: List<Photo> = emptyList(),
    @SerializedName("next_page")
    val nextPage: String = ""
)
