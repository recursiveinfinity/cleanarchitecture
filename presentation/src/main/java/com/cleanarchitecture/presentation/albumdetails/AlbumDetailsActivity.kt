package com.cleanarchitecture.presentation.albumdetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cleanarchitecture.news_sample_app.R
import com.cleanarchitecture.presentation.albums.UiAlbum
import com.cleanarchitecture.presentation.common.extensions.applyToolbarUp
import com.cleanarchitecture.presentation.navigation.NavigateArguments
import kotlinx.android.synthetic.main.activity_album_details.*

class AlbumDetailsActivity: AppCompatActivity() {

    private val album: UiAlbum by lazy {
        intent.getParcelableExtra(NavigateArguments.ALBUM) as UiAlbum
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_details)
        supportActionBar?.applyToolbarUp()
        supportActionBar?.title = "Album Details"

        tv_album_details_userId.text = album.userId
        tv_album_details_description.text = album.description
        tv_album_details_url.text = album.url
    }
}