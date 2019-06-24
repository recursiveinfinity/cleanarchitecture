package com.cleanarchitecture.data.mappers

import com.cleanarchitecture.data.entities.DataAlbum
import com.cleanarchitecture.data.entities.DataProduct
import com.cleanarchitecture.domain.albums.DomainAlbum
import com.cleanarchitecture.domain.albums.Domainproduct
import com.cleanarchitecture.domain.common.Mapper

/**
 * A mapper class that converts DataAlbum to DomainAlbum extends Mapper from domain layer and
 * implements the map method to add conversion logic
 */
class ProductMapper : Mapper<DataProduct, Domainproduct>{
    override fun map(from: DataProduct) = Domainproduct(
            productId = from.name,
            url = from.url,
            description = from.description,
            price= from.price,
            ratings= from.ratings,
            reviewCount = from.reviewCount

    )
}