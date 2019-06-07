package com.cleanarchitecture.presentation

import android.app.Application
import com.cleanarchitecture.presentation.di.mNetworkModules
import com.cleanarchitecture.presentation.di.mRepositoryModules
import com.cleanarchitecture.presentation.di.mUseCaseModules
import com.cleanarchitecture.presentation.di.mViewModels
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        loadKoin()
    }

    private fun loadKoin() {
        startKoin(this,
                listOf(mNetworkModules,
                        mViewModels,
                        mRepositoryModules,
                        mUseCaseModules
                )

        )
    }
}