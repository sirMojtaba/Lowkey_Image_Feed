package com.example.lowkeyimagefeed.data.repository

import com.example.lowkeyimagefeed.domain.PhotosResponse
import kotlinx.coroutines.flow.Flow

interface PhotosRepository {

    fun getPhotos(page: Int): Flow<PhotosResponse>
}