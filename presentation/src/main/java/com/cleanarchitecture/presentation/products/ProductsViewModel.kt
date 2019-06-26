package com.cleanarchitecture.presentation.products

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cleanarchitecture.domain.albums.GetProductsUseCase
import com.cleanarchitecture.domain.common.Mapper
import com.cleanarchitecture.domain.searchnavigation.DomainSearchNavigation
import com.cleanarchitecture.presentation.common.BaseViewModel
import com.cleanarchitecture.presentation.common.UiError
import com.cleanarchitecture.presentation.common.extensions.addTo
import com.cleanarchitecture.presentation.search.UiSearchNavigation


class ProductsViewModel(private val getProductsUseCase: GetProductsUseCase,
                        private val mapper: Mapper<DomainSearchNavigation, UiSearchNavigation>,
                        private val uiErrorMapper: Mapper<Throwable, UiError>) : BaseViewModel() {

    companion object {
        private val TAG = "ProductsViewModel"
    }

    private var loadingLiveData = MutableLiveData<Boolean>()
    private var contentLiveData = MutableLiveData<UiSearchNavigation>()
    private var errorLiveData = MutableLiveData<UiError>()

    fun getProducts() {
        loadingLiveData.value = true
        getProductsUseCase.execute()
                .map { mapper.map(it) }
                .subscribe({ response: UiSearchNavigation ->
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
    fun getContentObservable(): LiveData<UiSearchNavigation> = contentLiveData
    fun getErrorObservable(): LiveData<UiError> = errorLiveData
}