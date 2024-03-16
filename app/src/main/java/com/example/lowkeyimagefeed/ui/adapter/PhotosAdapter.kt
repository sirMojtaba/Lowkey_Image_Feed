package com.example.lowkeyimagefeed.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lowkeyimagefeed.databinding.ItemImageBinding
import com.example.lowkeyimagefeed.domain.Photo

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder>() {

    private var photos: List<Photo> = emptyList()

    fun setPhotos(photos: List<Photo>) {
        this.photos = photos
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val itemBinding =
            ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = photos[position]
        holder.bind(photo)
    }

    class PhotoViewHolder(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: Photo) {
            binding.authorsName.text = photo.photographer
            Glide.with(binding.root).load(photo.src.medium).into(binding.iv)
        }
    }
}
