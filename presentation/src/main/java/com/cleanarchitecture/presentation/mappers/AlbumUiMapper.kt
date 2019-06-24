package com.cleanarchitecture.presentation.mappers

import com.cleanarchitecture.domain.common.Mapper
import com.cleanarchitecture.domain.albums.DomainAlbum
import com.cleanarchitecture.presentation.albums.UiAlbum

class AlbumUiMapper : Mapper<DomainAlbum, UiAlbum> {

    override fun map(from: DomainAlbum) = UiAlbum(
            userId = from.userId,
            description = from.description,
            url = from.url
    )
}

