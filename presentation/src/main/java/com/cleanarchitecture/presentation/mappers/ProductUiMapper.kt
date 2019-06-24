package com.cleanarchitecture.presentation.mappers

import com.cleanarchitecture.domain.albums.Domainproduct
import com.cleanarchitecture.domain.common.Mapper
import com.cleanarchitecture.presentation.albums.Products.UiProduct

class ProductUiMapper : Mapper<Domainproduct, UiProduct> {

    override fun map(from: Domainproduct) = UiProduct(
            productId = from.productId,
            description = from.description,
            url = from.url
    )
}

