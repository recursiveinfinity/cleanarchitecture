package com.cleanarchitecture.presentation.albums

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UiAlbum(
        var userId: String? = null,
        var description: String? = null,
        var url: String? = null
) : Parcelable