package com.cleanarchitecture.domain.common

import io.reactivex.SingleTransformer

/**
 * This class extends SingleTransformer class, which is part of RxJava. SingleTransformer or
 * any version of Transformer is helpful to apply a series of transformations to a stream.
 *  https://blog.danlew.net/2015/03/02/dont-break-the-chain/
 */
abstract class SingleRxTransformer<T> : SingleTransformer<T, T>