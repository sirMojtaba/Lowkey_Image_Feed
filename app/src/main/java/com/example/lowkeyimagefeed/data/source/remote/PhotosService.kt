package com.example.lowkeyimagefeed.data.source.remote

import com.example.lowkeyimagefeed.domain.Photo
import kotlinx.coroutines.flow.Flow

interface PhotosService {

    fun fetchPhotos(page: Int): Flow<List<Photo>?>
    fun addPhoto(photo: Photo)
    fun readPhotos(): Flow<List<Photo>>
}