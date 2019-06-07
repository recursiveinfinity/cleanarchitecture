package com.cleanarchitecture.presentation

import android.app.Application
import com.cleanarchitecture.presentation.di.networkModules
import com.cleanarchitecture.presentation.di.repositoryModules
import com.cleanarchitecture.presentation.di.useCaseModules
import com.cleanarchitecture.presentation.di.viewModels
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        loadKoin()
    }

    private fun loadKoin() {
        startKoin(this,
                listOf(networkModules,
                        viewModels,
                        repositoryModules,
                        useCaseModules
                )

        )
    }
}