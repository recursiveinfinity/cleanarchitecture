package com.cleanarchitecture.data.repository

import com.cleanarchitecture.data.datastore.AlbumRemoteDataStore
import com.cleanarchitecture.data.mappers.AlbumMapper
import com.cleanarchitecture.domain.albums.AlbumsRepository
import com.cleanarchitecture.domain.albums.DomainAlbum
import io.reactivex.Single

class AlbumsRepositoryImpl(private val remote: AlbumRemoteDataStore) : AlbumsRepository {

    private val albumMapper = AlbumMapper()

    override fun getAlbums(): Single<List<DomainAlbum>> = remote.getNews()
            .map { albumMapper.toDomainList(it) }
}
