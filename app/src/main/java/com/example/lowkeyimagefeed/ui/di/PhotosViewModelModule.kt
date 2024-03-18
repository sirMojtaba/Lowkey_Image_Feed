package com.example.lowkeyimagefeed.ui.di

import com.example.lowkeyimagefeed.data.remote.api.ApiService
import com.example.lowkeyimagefeed.data.repository.PhotosRepository
import com.example.lowkeyimagefeed.data.repository.PhotosRepositoryImpl
import com.example.lowkeyimagefeed.data.source.local.AppDatabase
import com.example.lowkeyimagefeed.data.source.remote.PhotosService
import com.example.lowkeyimagefeed.framework.service.PhotosServiceImpl
import com.example.lowkeyimagefeed.usecase.GetPhotosInteractor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object PhotosViewModelModule {

    @Provides
    @ViewModelScoped
    fun providePhotosService(apiService: ApiService, appDatabase: AppDatabase): PhotosService {
        return PhotosServiceImpl(apiService, appDatabase)
    }

    @Provides
    @ViewModelScoped
    fun providePhotosRepository(service: PhotosService): PhotosRepository {
        return PhotosRepositoryImpl(service)
    }

    @Provides
    @ViewModelScoped
    fun provideGetPhotosInteractor(repository: PhotosRepository): GetPhotosInteractor {
        return GetPhotosInteractor(repository)
    }
}