package com.cleanarchitecture.presentation.albums.Products

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UiProduct(
        var productId: String? = null,
        var description: String? = null,
        var url: String? = null
) : Parcelable