package com.example.lowkeyimagefeed.data.repository

import com.example.lowkeyimagefeed.data.source.remote.PhotosService
import com.example.lowkeyimagefeed.domain.Photo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PhotosRepositoryImpl(private val photosService: PhotosService) : PhotosRepository {

    override fun getPhotos(page: Int): Flow<List<Photo>> {
        return flow {
            photosService.fetchPhotos(page).collect { remotePhotos ->
                if (!remotePhotos.isNullOrEmpty()) {
                    remotePhotos.forEach { photo ->
                        photosService.addPhoto(photo)
                    }
                    emit(remotePhotos)
                } else {
                    photosService.readPhotos().collect { localPhotos ->
                        emit(localPhotos)
                    }
                }
            }
        }
    }
}