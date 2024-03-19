package com.example.lowkeyimagefeed.framework.service

import com.example.lowkeyimagefeed.data.mapper.toEntity
import com.example.lowkeyimagefeed.data.mapper.toPhoto
import com.example.lowkeyimagefeed.data.remote.api.ApiService
import com.example.lowkeyimagefeed.data.source.local.AppDatabase
import com.example.lowkeyimagefeed.data.source.remote.PhotosService
import com.example.lowkeyimagefeed.domain.Photo
import com.example.lowkeyimagefeed.framework.utils.NetworkConsts
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PhotosServiceImpl @Inject constructor(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase
) : PhotosService {

    override fun fetchPhotos(page: Int): Flow<List<Photo>?> {
        return flow {
            val photos: MutableList<Photo>? = try {
                apiService.getPhotos(
                    NetworkConsts.API_KEY,
                    mapOf("page" to page, "per_page" to 10)
                ).photos.toMutableList()
            } catch (e: Exception) {
                null
            }
            emit(photos)
        }
    }

    override fun addPhoto(photo: Photo) {
        appDatabase.photoDao.insertPhoto(photo.toEntity())
    }

    override fun readPhotos(): Flow<List<Photo>> {
        return flow {
            val photos: MutableList<Photo> = mutableListOf()
            appDatabase.photoDao.readAllPhotos().forEach {
                photos.add(it.toPhoto())
            }
            emit(photos)
        }
    }
}