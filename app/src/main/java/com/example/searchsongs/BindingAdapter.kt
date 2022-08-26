package com.example.searchsongs

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.searchsongs.network.Songs
import com.example.searchsongs.overview.PhotoGridAdapter

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView , imgUrl :String?){
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        imgView.load(imgUri){
            error(R.drawable.ic_broken_img)
        }
    }
}


fun bindRecyclerView(recyclerView: RecyclerView , data:List<Songs>?){
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)

}