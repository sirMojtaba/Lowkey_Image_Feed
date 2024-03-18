package com.example.lowkeyimagefeed.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import com.example.lowkeyimagefeed.R
import com.example.lowkeyimagefeed.databinding.FragmentHomeBinding
import com.example.lowkeyimagefeed.domain.Photo
import com.example.lowkeyimagefeed.ui.adapter.PhotosAdapter
import com.example.lowkeyimagefeed.ui.home.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var adapter: PhotosAdapter
    private var page: Int = 1
    private var photos: List<Photo> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fetchData()
        adapter = PhotosAdapter()
    }

    private fun fetchData() {
        viewModel.getPhotos(page)
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
        adapter.setOnImageClickListener(object : PhotosAdapter.OnImageClickListener {
            override fun onImageClick(photo: Photo) {
                findNavController().navigate(
                    R.id.action_homeFragment_to_detailFragment,
                    bundleOf("photo" to photo)
                )
            }
        })

        binding.recyclerview.addOnScrollListener(object : OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    fetchData()
                }
            }
        })

        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.getPhotos(1)
            photos = emptyList()
            lifecycleScope.launch {
                if (binding.swipeRefreshLayout.isRefreshing) {
                    binding.swipeRefreshLayout.isRefreshing = false
                }
                delay(1000)
            }
        }
    }

    private fun registerObservers() {
        viewModel.photos.observe(viewLifecycleOwner) { photoList ->
            photos += photoList
            photos = photos.distinct()
            adapter.setPhotos(photos)
            page += 1
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}