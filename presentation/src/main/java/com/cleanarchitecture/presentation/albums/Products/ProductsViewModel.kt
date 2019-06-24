package com.cleanarchitecture.presentation.albums.Products

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.cleanarchitecture.domain.albums.Domainproduct
import com.cleanarchitecture.domain.albums.GetProductsUseCase
import com.cleanarchitecture.domain.common.Mapper
import com.cleanarchitecture.presentation.common.BaseViewModel
import com.cleanarchitecture.presentation.common.UiError


class ProductListViewModel (private val getProductsUseCase: GetProductsUseCase,
                            private val mapper: Mapper<Domainproduct, UiProduct>,
                            private val uiErrorMapper: Mapper<Throwable, UiError>) : BaseViewModel() {

    companion object {
        private val TAG = "ProductListViewModel"
    }

    var loadingLiveData = MutableLiveData<Boolean>()
    var contentLiveData = MutableLiveData<List<UiProduct>>()
    var errorLiveData = MutableLiveData<UiError>()

    fun getProducts() {
        val disposable = getProductsUseCase.execute()
                .map { mapper.mapList(it) }
                .subscribe({ response: List<UiProduct> ->
                    contentLiveData.value = response
                }, { error: Throwable ->
                    Log.d(TAG, error.message)
                    errorLiveData.value = uiErrorMapper.map(error)
                })
        addDisposable(disposable)
    }
}