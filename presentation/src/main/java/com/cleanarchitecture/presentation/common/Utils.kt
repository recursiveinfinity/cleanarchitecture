package com.cleanarchitecture.presentation.common

fun consume(syncFunc: () -> Unit): Boolean {
    syncFunc.invoke()
    return true
}