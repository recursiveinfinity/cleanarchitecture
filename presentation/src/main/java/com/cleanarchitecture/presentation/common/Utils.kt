package com.cleanarchitecture.presentation.common

import android.content.Context
import android.util.TypedValue

fun consume(syncFun: () -> Unit): Boolean {
    syncFun.invoke()
    return true
}

fun Number.spToPx(context: Context) = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP, this.toFloat(), context.resources.displayMetrics).toInt()
