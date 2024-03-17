package com.example.lowkeyimagefeed.data.repository

import com.example.lowkeyimagefeed.domain.PhotosResponse
import kotlinx.coroutines.flow.Flow

class PhotosRepositoryImpl(private val photosService: PhotosService) : PhotosRepository {

    override fun getPhotos(): Flow<PhotosResponse> {
        return photosService.getPhotos()
    }
}