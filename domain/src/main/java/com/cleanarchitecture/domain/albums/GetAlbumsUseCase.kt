package com.cleanarchitecture.domain.albums

import com.cleanarchitecture.domain.common.SingleNoParamsUseCase
import com.cleanarchitecture.domain.common.SingleRxTransformer
import io.reactivex.Single

class GetAlbumsUseCase(transformer: SingleRxTransformer<List<DomainAlbum>>,
                       private val repositories: AlbumsRepository) : SingleNoParamsUseCase<List<DomainAlbum>>(transformer) {

    override fun create(): Single<List<DomainAlbum>> =
            repositories.getAlbums()
}