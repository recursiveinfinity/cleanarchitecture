package com.cleanarchitecture.data.mappers

import com.cleanarchitecture.data.entities.DataAlbum
import com.cleanarchitecture.domain.albums.DomainAlbum
import com.cleanarchitecture.domain.common.Mapper

/**
 * A mapper class that converts DataAlbum to DomainAlbum extends Mapper from domain layer and
 * implements the map method to add conversion logic
 */
class AlbumMapper : Mapper<DataAlbum, DomainAlbum>{
    override fun map(from: DataAlbum) = DomainAlbum(
    userId = from.name,
    url = from.url,
    description = from.description
    )
}