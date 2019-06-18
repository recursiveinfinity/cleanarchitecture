package com.cleanarchitecture.domain.albums

import com.cleanarchitecture.domain.common.SingleNoParamsUseCase
import com.cleanarchitecture.domain.common.SingleRxTransformer
import io.reactivex.Single

/**
 * A use case that retrieves a list of albums on execution. It extends SingleNoParamsUseCase and
 * overrides the create method to create a Single<List<DomainAlbum>>
 * @param transformer - A SingleRxTransformer of type List<DomainAlbum>
 * @param repositories - An implementation of AlbumsRepository
 */
class GetAlbumsUseCase(transformer: SingleRxTransformer<List<DomainAlbum>>,
                       private val repositories: AlbumsRepository) : SingleNoParamsUseCase<List<DomainAlbum>>(transformer) {

    override fun create(): Single<List<DomainAlbum>> =
            repositories.getAlbums()
}