package com.example.lowkeyimagefeed.usecase

import com.example.lowkeyimagefeed.data.repository.PhotosRepository
import com.example.lowkeyimagefeed.domain.Photo
import kotlinx.coroutines.flow.Flow

class GetPhotosInteractor(private val repository: PhotosRepository) {

    fun execute(page: Int): Flow<List<Photo>> {
        return repository.getPhotos(page)
    }
}