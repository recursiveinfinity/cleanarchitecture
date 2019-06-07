package com.cleanarchitecture.presentation.common

import com.cleanarchitecture.domain.common.SingleRxTransformer
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AsyncSingleTransformer<T> : SingleRxTransformer<T>() {

    override fun apply(upstream: Single<T>): Single<T> = upstream
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}