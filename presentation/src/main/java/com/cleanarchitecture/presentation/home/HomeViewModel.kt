package com.cleanarchitecture.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cleanarchitecture.domain.common.Mapper
import com.cleanarchitecture.domain.home.DomainPromotedItem
import com.cleanarchitecture.domain.home.GetPromotedItemsUseCase
import com.cleanarchitecture.presentation.common.BaseViewModel
import com.cleanarchitecture.presentation.common.UiError
import com.cleanarchitecture.presentation.common.extensions.addTo

class HomeViewModel(private val getPromotedItemUseCase: GetPromotedItemsUseCase,
                    private val mapper: Mapper<DomainPromotedItem, UiPromotedItem>,
                    private val uiErrorMapper: Mapper<Throwable, UiError>) : BaseViewModel() {

    private val loadingLiveData = MutableLiveData<Boolean>()
    private val contentLiveData = MutableLiveData<List<UiPromotedItem>>()
    private val errorLiveData = MutableLiveData<UiError>()


    fun getPromotedItems() {
        getPromotedItemUseCase.execute()
                .map { mapper.mapList(it) }
                .doOnSubscribe { loadingLiveData.value = true }
                .doOnEvent { _, _ -> loadingLiveData.value = false }
                .subscribe({ result: List<UiPromotedItem> -> contentLiveData.value = result },
                        { error: Throwable -> errorLiveData.value = uiErrorMapper.map(error) })
                .addTo(compositeDisposable)

    }

    fun getLoadingObservable(): LiveData<Boolean> = loadingLiveData
    fun getContentObservable(): LiveData<List<UiPromotedItem>> = contentLiveData
    fun getErrorObservable(): LiveData<UiError> = errorLiveData

}