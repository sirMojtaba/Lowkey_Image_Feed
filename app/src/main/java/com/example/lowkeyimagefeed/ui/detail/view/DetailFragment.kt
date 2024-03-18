package com.example.lowkeyimagefeed.ui.detail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.lowkeyimagefeed.databinding.FragmentDetailBinding
import com.example.lowkeyimagefeed.domain.Photo
import com.example.lowkeyimagefeed.ui.detail.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DetailViewModel by viewModels()
    private lateinit var photo: Photo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        photo = arguments?.getSerializable("photo") as Photo
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(view).load(photo.src.large).override(30, 30).into(binding.ivBlur)
        Glide.with(view).load(photo.src.large2x).into(binding.iv)
        if (photo.photographer.isNotBlank()) {
            binding.tvAuthorsName.text = photo.photographer
        } else {
            binding.tvAuthorsName.visibility = View.GONE
        }
        if (photo.alt.isNotBlank()) {
            binding.tvDescriptoin.text = photo.alt
        } else {
            binding.tvDescriptoin.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}