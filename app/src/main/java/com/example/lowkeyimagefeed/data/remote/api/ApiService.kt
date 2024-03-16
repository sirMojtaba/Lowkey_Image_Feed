package com.example.lowkeyimagefeed.data.remote.api

import com.example.lowkeyimagefeed.domain.PhotosResponse
import com.example.lowkeyimagefeed.domain.RequestPhotos
import com.example.lowkeyimagefeed.framework.utils.NetworkConsts
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface ApiService {

    @GET(NetworkConsts.CURATED_PHOTOS)
    fun getPhotos(@Body requestPhotos: RequestPhotos): Response<PhotosResponse>
}