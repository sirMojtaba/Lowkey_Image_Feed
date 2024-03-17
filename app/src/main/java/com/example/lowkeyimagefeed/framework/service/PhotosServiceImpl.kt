package com.example.lowkeyimagefeed.framework.service

import com.example.lowkeyimagefeed.data.remote.api.ApiService
import com.example.lowkeyimagefeed.data.repository.PhotosService
import com.example.lowkeyimagefeed.domain.PhotosResponse
import com.example.lowkeyimagefeed.framework.utils.NetworkConsts
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PhotosServiceImpl @Inject constructor(private val apiService: ApiService) : PhotosService {

    override fun getPhotos(): Flow<PhotosResponse> {
        return flow {
            emit(apiService.getPhotos(NetworkConsts.API_KEY, mapOf("page" to 1, "per_page" to 15)))
        }
    }
}