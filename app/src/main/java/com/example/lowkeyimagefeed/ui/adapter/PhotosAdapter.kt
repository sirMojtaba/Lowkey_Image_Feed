package com.example.lowkeyimagefeed.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lowkeyimagefeed.databinding.ItemImageBinding
import com.example.lowkeyimagefeed.domain.Photo

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder>() {

    private var photos: List<Photo> = emptyList()
    private lateinit var onImageClickListener: OnImageClickListener

    fun setPhotos(photos: List<Photo>) {
        this.photos = photos
        notifyDataSetChanged()
    }

    fun setOnImageClickListener(onImageClickListener: OnImageClickListener) {
        this.onImageClickListener = onImageClickListener
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
        holder.itemView.setOnClickListener {
            onImageClickListener.onImageClick(photo)
        }
    }

    class PhotoViewHolder(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: Photo) {
            binding.tvAuthorsName.text = photo.photographer
            Glide.with(binding.root).load(photo.src.medium).into(binding.iv)
        }
    }

    interface OnImageClickListener {
        fun onImageClick(phot: Photo)
    }
}
