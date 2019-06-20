package com.cleanarchitecture.data.repository

import com.cleanarchitecture.data.datastore.AlbumRemoteDataStore
import com.cleanarchitecture.data.mappers.AlbumMapper
import com.cleanarchitecture.domain.albums.AlbumsRepository
import com.cleanarchitecture.domain.albums.DomainAlbum
import io.reactivex.Single

/**
 * Implementation of AlbumsRepository from domain layer
 * @param remote - A data store to retrieve data from a remote data source
 */
class AlbumsRepositoryImpl(private val remote: AlbumRemoteDataStore) : AlbumsRepository {

    private val albumMapper = AlbumMapper()

    /**
     * @return Single<List<DomainAlbum>> - converts Single<List<Albums> retrieved from the API to
     * List<DomainAlbum>> by utilising the mapper
     */
    override fun getAlbums(): Single<List<DomainAlbum>> = remote.getNews()
            .map { albumMapper.mapList(it) }
}
