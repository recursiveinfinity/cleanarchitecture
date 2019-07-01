package com.cleanarchitecture.presentation

import android.app.Application
import com.cleanarchitecture.presentation.di.*
import com.richrelevance.ClientConfiguration
import com.richrelevance.Endpoint
import com.richrelevance.RRLog
import com.richrelevance.RichRelevance
import org.koin.android.ext.android.startKoin
import java.util.*

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        loadKoin()
        initRichRelevance()
    }

    private fun loadKoin() {
        startKoin(this,
                listOf(networkModules,
                        viewModels,
                        repositoryModules,
                        useCaseModules,
                        navigator,
                        fragments,
                        mappers
                )

        )
    }

    private fun initRichRelevance() {
        //TODO SECURE CREDENTIALS
        RichRelevance.init(
                this,
                ClientConfiguration("9c34127183f54b6e", "a924f3a59fe5a5ac").apply {
                    apiClientSecret = "chn3so5i6br1msemq8t4na8gpa"
                    userId = "2c1bac3f05c16612e07a9e3ed19f325e" //TODO REPLACE FOR PRODUCTION
                    sessionId = UUID.randomUUID().toString()
                    setEndpoint(Endpoint.INTEGRATION, true)
                }
        )
        RichRelevance.setLoggingLevel(RRLog.VERBOSE) //TODO: REPLACE FOR PRODUCTION
    }
}