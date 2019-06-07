package com.cleanarchitecture.domain.common

import io.reactivex.Single


abstract class SingleNoParamsUseCase<T>(private val transformer: SingleRxTransformer<T>) {

    abstract fun create(): Single<T>

    fun execute(): Single<T> = create().compose(transformer)
}