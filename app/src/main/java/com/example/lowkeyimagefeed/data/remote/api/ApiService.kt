package com.example.lowkeyimagefeed.data.remote.api

import com.example.lowkeyimagefeed.domain.PhotosResponse
import com.example.lowkeyimagefeed.framework.utils.NetworkConsts
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.QueryMap

interface ApiService {

    @GET(NetworkConsts.CURATED_PHOTOS)
    suspend fun getPhotos(
        @Header("authorization") authorization: String,
        @QueryMap params: Map<String, Int>
    ): Response<PhotosResponse>
}