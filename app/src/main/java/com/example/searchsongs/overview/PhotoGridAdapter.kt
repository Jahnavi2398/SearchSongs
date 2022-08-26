package com.example.searchsongs.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.searchsongs.databinding.GridviewBinding
import com.example.searchsongs.network.Songs

class PhotoGridAdapter : ListAdapter<Songs , PhotoGridAdapter.PhotoViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoGridAdapter.PhotoViewHolder {
        return PhotoViewHolder(GridviewBinding.inflate((LayoutInflater.from(parent.context))))
    }

    override fun onBindViewHolder(holder: PhotoGridAdapter.PhotoViewHolder, position: Int) {
        val songs = getItem(position)
        holder.bind(songs)
    }

    companion object DiffCallback :DiffUtil.ItemCallback<Songs>(){
        override fun areItemsTheSame(oldItem: Songs, newItem: Songs): Boolean {
            return oldItem.results[0].artistId == newItem.results[0].artistId
        }

        override fun areContentsTheSame(oldItem: Songs, newItem: Songs): Boolean {
            return oldItem.results[0].artworkUrl100 == newItem.results[0].artworkUrl100
        }

    }

    class PhotoViewHolder(private var binding: GridviewBinding):
        RecyclerView.ViewHolder(binding.root){
            fun bind  (Songs : Songs){
                binding.photo = Songs
                binding.executePendingBindings()
            }

        }

}