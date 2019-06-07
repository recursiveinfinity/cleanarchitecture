package com.cleanarchitecture.presentation.common

data class UiError(var title: String? = null, var message: String? = null, var positive: String? = null, var errorViewType: ErrorViewType, var cancelable: Boolean, var throwable: Throwable)

enum class ErrorViewType {
    DIALOG, FULLSCREEN, TOAST
}