package com.cleanarchitecture.presentation

import android.app.Application
import com.cleanarchitecture.presentation.di.*
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
                        useCaseModules,
                        navigator
                )

        )
    }
}