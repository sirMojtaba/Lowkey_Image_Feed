package com.example.lowkeyimagefeed.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.lowkeyimagefeed.databinding.FragmentHomeBinding
import com.example.lowkeyimagefeed.domain.RequestPhotos
import com.example.lowkeyimagefeed.ui.adapter.PhotosAdapter
import com.example.lowkeyimagefeed.ui.home.viewModel.HomeViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var adapter: PhotosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fetchData()
        adapter = PhotosAdapter()
    }

    private fun fetchData() {
        viewModel.getPhotos(RequestPhotos())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerObservers()
        binding.recyclerview.adapter = adapter
    }

    private fun registerObservers() {
        viewModel.photos.observe(viewLifecycleOwner) {
            val photos = it.photos
            adapter.setPhotos(photos)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}