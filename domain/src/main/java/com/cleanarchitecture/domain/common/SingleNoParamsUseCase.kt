package com.cleanarchitecture.domain.common

import io.reactivex.Single

/**
 * This class serves as an abstract use case to create or transform a Single stream
 * @param T - A generic object of type T. For example - SingleNoParamsUseCase<String> would lead
 * to creation of Single<String> once create() is called
 */
abstract class SingleNoParamsUseCase<T>(private val transformer: SingleRxTransformer<T>) {

    abstract fun create(): Single<T>

    fun execute(): Single<T> = create().compose(transformer)
}