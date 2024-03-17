package com.example.lowkeyimagefeed.usecase

import com.example.lowkeyimagefeed.data.repository.PhotosRepository
import com.example.lowkeyimagefeed.domain.PhotosResponse
import kotlinx.coroutines.flow.Flow

class GetPhotosInteractor(private val repository: PhotosRepository) {

    fun execute(): Flow<PhotosResponse> {
        return repository.getPhotos()
    }
}