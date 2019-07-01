package com.cleanarchitecture.presentation.products

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cleanarchitecture.domain.common.Mapper
import com.cleanarchitecture.domain.products.GetProductsUseCase
import com.cleanarchitecture.presentation.common.BaseViewModel
import com.cleanarchitecture.presentation.common.UiError
import com.cleanarchitecture.presentation.common.extensions.addTo
import com.cleanarchitecture.presentation.mappers.ProductListingMapper


class ProductsViewModel(private val getProductsUseCase: GetProductsUseCase,
                        private val mapper: ProductListingMapper,
                        private val uiErrorMapper: Mapper<Throwable, UiError>) : BaseViewModel() {

    companion object {
        private val TAG = "ProductsViewModel"
    }

    private var loadingLiveData = MutableLiveData<Boolean>()
    private var contentLiveData = MutableLiveData<List<UiProductListing>>()
    private var errorLiveData = MutableLiveData<UiError>()

    fun getProducts() {
        loadingLiveData.value = true
        getProductsUseCase.execute()
                .map { mapper.map(it) }
                .subscribe({ response: List<UiProductListing> ->
                    loadingLiveData.value = false
                    contentLiveData.value = response
                }, { error: Throwable ->
                    Log.d(TAG, error.message)
                    loadingLiveData.value = false
                    errorLiveData.value = uiErrorMapper.map(error)
                })
                .addTo(compositeDisposable)
    }

    fun getLoadingObservable(): LiveData<Boolean> = loadingLiveData
    fun getContentObservable(): LiveData<List<UiProductListing>> = contentLiveData
    fun getErrorObservable(): LiveData<UiError> = errorLiveData
}