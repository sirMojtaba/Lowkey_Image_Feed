package com.example.lowkeyimagefeed.usecase

import com.example.lowkeyimagefeed.data.repository.PhotosRepository
import com.example.lowkeyimagefeed.domain.PhotosResponse
import com.example.lowkeyimagefeed.domain.RequestPhotos
import kotlinx.coroutines.flow.Flow

class GetPhotosInteractor(private val repository: PhotosRepository) {

    fun execute(requestPhotos: RequestPhotos): Flow<PhotosResponse> {
        return repository.getPhotos(requestPhotos)
    }
}