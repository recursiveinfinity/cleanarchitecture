package com.cleanarchitecture.presentation.splash

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.cleanarchitecture.news_sample_app.R
import com.cleanarchitecture.presentation.common.ErrorViewType
import com.cleanarchitecture.presentation.common.UiError
import com.cleanarchitecture.presentation.navigation.AppNavigator
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import android.view.View
import android.view.Window


class SplashActivity : AppCompatActivity() {

    private val navigator: AppNavigator by inject { parametersOf(this) }
    private val splashViewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.cleanarchitecture.news_sample_app.R.layout.activity_splash)

        //Makes Activity go FullScreen
        window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        splashViewModel.getContentObservable().observe(this, Observer { content() })
        splashViewModel.getErrorObservable().observe(this, Observer { error(it) })
        splashViewModel.onLaunch()
    }


    private fun content() {
        navigator.toHome().also { finish() }
    }

    private fun error(error: UiError) {
        when (error.errorViewType) {
            ErrorViewType.DIALOG -> {
                AlertDialog.Builder(this)
                        .setTitle(error.title)
                        .setMessage(error.message)
                        .setPositiveButton(error.positive) { dialog, _ -> dialog.dismiss() }
                        .setCancelable(error.cancelable)
                        .show()
            }
            else -> {
                // NOOP
            }
        }
    }
}
