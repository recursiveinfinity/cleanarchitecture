package com.cleanarchitecture.presentation.navigation

import com.cleanarchitecture.presentation.albums.UiAlbum

interface Navigator {
    fun back()
    fun toUrl(url: String, title: String)
    fun toLaunchActivity()
    fun toAlbums()
    fun toAlbumDetails(album: UiAlbum)
    fun toHome()
}