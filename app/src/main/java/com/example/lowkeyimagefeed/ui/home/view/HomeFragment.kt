package com.example.lowkeyimagefeed.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.lowkeyimagefeed.R
import com.example.lowkeyimagefeed.domain.RequestPhotos
import com.example.lowkeyimagefeed.ui.home.viewModel.HomeViewModel

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fetchData()
    }

    private fun fetchData() {
        viewModel.getPhotos(RequestPhotos())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerObservers()
    }

    private fun registerObservers() {
        viewModel.photos.observe(viewLifecycleOwner) {

        }
    }
}