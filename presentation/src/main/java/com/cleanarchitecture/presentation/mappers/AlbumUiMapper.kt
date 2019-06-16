package com.cleanarchitecture.presentation.mappers

import com.cleanarchitecture.domain.common.Mapper
import com.cleanarchitecture.domain.albums.DomainAlbum
import com.cleanarchitecture.presentation.albums.UiAlbum

class AlbumUiMapper : Mapper<List<DomainAlbum>, List<UiAlbum>>() {

    override fun toUi(from: List<DomainAlbum>) = from.map {
        toUi(it)
    }

    private fun toUi(response: DomainAlbum) = UiAlbum(
            userId = response.userId,
            description = response.description,
            url = response.url
    )
}

