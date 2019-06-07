package com.cleanarchitecture.presentation.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cleanarchitecture.news_sample_app.R
import kotlinx.android.synthetic.main.list_item_album.view.*

class AlbumsAdapter : RecyclerView.Adapter<AlbumsAdapter.AlbumViewHolder>() {

    var albums = mutableListOf<UiAlbum>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            AlbumViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_album, parent, false))

    override fun getItemCount() = albums.size

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(albums[position])
    }

    class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(uiAlbum: UiAlbum) {
            with(itemView) {
                tv_title.text = uiAlbum.description
            }
        }
    }

    fun updateList(list: List<UiAlbum>) {
        if (list.isNotEmpty()) {
            albums.clear()
            albums.addAll(list)
            notifyDataSetChanged()
        }
    }
}