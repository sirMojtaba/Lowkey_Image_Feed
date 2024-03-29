package com.example.lowkeyimagefeed.ui.home.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lowkeyimagefeed.domain.Photo
import com.example.lowkeyimagefeed.usecase.GetPhotosInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPhotosInteractor: GetPhotosInteractor
) : ViewModel() {

    private val _photos: MutableLiveData<List<Photo>> = MutableLiveData()
    val photos: LiveData<List<Photo>> = _photos

    fun getPhotos(page: Int) {
        viewModelScope.launch {
            getPhotosInteractor.execute(page).collect {
                _photos.value = it
            }
        }
    }
}