package com.cleanarchitecture.presentation.albums

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.cleanarchitecture.domain.albums.DomainAlbum
import com.cleanarchitecture.domain.albums.GetAlbumsUseCase
import com.cleanarchitecture.domain.common.Mapper
import com.cleanarchitecture.presentation.common.BaseViewModel
import com.cleanarchitecture.presentation.common.UiError

class AlbumsViewModel(private val getAlbumsUseCase: GetAlbumsUseCase,
                      private val mapper: Mapper<List<DomainAlbum>, List<UiAlbum>>,
                      private val uiErrorMapper: Mapper<Throwable, UiError>) : BaseViewModel() {

    companion object {
        private val TAG = "AlbumsViewModel"
    }

    var loadingLiveData = MutableLiveData<Boolean>()
    var contentLiveData = MutableLiveData<List<UiAlbum>>()
    var errorLiveData = MutableLiveData<UiError>()

    fun getAlbums() {
        val disposable = getAlbumsUseCase.execute()
                .map { mapper.toUiList(it) }
                .subscribe({ response: List<UiAlbum> ->
                    contentLiveData.value = response
                }, { error: Throwable ->
                    Log.d(TAG, error.message)
                    errorLiveData.value = uiErrorMapper.toUiList(error)
                })
        addDisposable(disposable)
    }
}