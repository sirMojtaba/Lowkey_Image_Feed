package com.example.lowkeyimagefeed.data.repository

import com.example.lowkeyimagefeed.domain.PhotosResponse
import com.example.lowkeyimagefeed.domain.RequestPhotos
import kotlinx.coroutines.flow.Flow

interface PhotosService {

    fun getPhotos(requestPhotos: RequestPhotos): Flow<PhotosResponse>
}