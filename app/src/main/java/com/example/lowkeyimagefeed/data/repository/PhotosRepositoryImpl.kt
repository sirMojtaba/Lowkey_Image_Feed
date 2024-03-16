package com.example.lowkeyimagefeed.data.repository

import com.example.lowkeyimagefeed.domain.PhotosResponse
import com.example.lowkeyimagefeed.domain.RequestPhotos
import kotlinx.coroutines.flow.Flow

class PhotosRepositoryImpl(private val photosService: PhotosService) : PhotosRepository {

    override fun getPhotos(requestPhotos: RequestPhotos): Flow<PhotosResponse> {
        return photosService.getPhotos(requestPhotos)
    }
}