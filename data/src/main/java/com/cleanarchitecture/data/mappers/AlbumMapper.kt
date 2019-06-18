package com.cleanarchitecture.data.mappers

import com.cleanarchitecture.data.entities.DataAlbum
import com.cleanarchitecture.domain.albums.DomainAlbum

/**
 * A mapper class that converts DataAlbum to DomainAlbum
 */
class AlbumMapper {

    fun toDomainList(list: List<DataAlbum>): List<DomainAlbum> = list.map {
        toDomain(it)
    }

    fun toDomain(data: DataAlbum): DomainAlbum = DomainAlbum(
            userId = data.name,
            url = data.url,
            description = data.description
    )

}