package com.cleanarchitecture.domain.searchnavigation

import com.cleanarchitecture.domain.common.SingleRxTransformer
import com.cleanarchitecture.domain.common.SingleUseCase
import io.reactivex.Single

class GetProductsBySearchAutocompleteUseCase(transformer: SingleRxTransformer<List<String>>,
                                             private val repositories: SearchRepository) : SingleUseCase<GetProductsBySearchAutocompleteUseCase.Params, List<String>>(transformer) {

    class Params(val query: String, val max_results: Int, val beginning: Int)

    override fun create(params: Params): Single<List<String>> =
            repositories.getAutocomplete(query = params.query, max_results = params.max_results, beginning = params.beginning)
}