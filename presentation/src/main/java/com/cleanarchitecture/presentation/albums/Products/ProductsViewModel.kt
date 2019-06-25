package com.cleanarchitecture.presentation.albums.Products

import android.util.Log
import androidx.lifecycle.MutableLiveData
//import com.cleanarchitecture.domain.albums.Domainproduct
import com.cleanarchitecture.domain.albums.GetProductsUseCase
import com.cleanarchitecture.domain.common.Mapper
import com.cleanarchitecture.domain.searchnavigation.DomainResults
import com.cleanarchitecture.presentation.common.BaseViewModel
import com.cleanarchitecture.presentation.common.UiError
import com.cleanarchitecture.presentation.common.extensions.addTo


class ProductListViewModel (private val getProductsUseCase: GetProductsUseCase,
                            private val mapper: Mapper<DomainResults, UiProduct>,
                            private val uiErrorMapper: Mapper<Throwable, UiError>) : BaseViewModel() {

    companion object {
        private val TAG = "ProductListViewModel"
    }

    var loadingLiveData = MutableLiveData<Boolean>()
    var contentLiveData = MutableLiveData<List<UiProduct>>()
    var errorLiveData = MutableLiveData<UiError>()

    fun getProducts() {
       getProductsUseCase.execute()
                .map { mapper.mapList(it) }
                .subscribe({ response: List<UiProduct> ->
                    contentLiveData.value = response
                }, { error: Throwable ->
                    Log.d(TAG, error.message)
                    errorLiveData.value = uiErrorMapper.map(error)
                })
                .addTo(compositeDisposable)
    }
}