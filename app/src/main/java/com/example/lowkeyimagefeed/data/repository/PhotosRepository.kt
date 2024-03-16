package com.example.lowkeyimagefeed.data.repository

import com.example.lowkeyimagefeed.domain.PhotosResponse
import com.example.lowkeyimagefeed.domain.RequestPhotos
import kotlinx.coroutines.flow.Flow

interface PhotosRepository {

    fun getPhotos(requestPhotos: RequestPhotos): Flow<PhotosResponse>
}