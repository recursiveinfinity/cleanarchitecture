package com.cleanarchitecture.domain.albums

import io.reactivex.Single

interface AlbumsRepository {
    fun getAlbums(): Single<List<DomainAlbum>>
}