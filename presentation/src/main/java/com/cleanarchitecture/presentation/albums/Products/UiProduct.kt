package com.cleanarchitecture.presentation.albums.Products

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UiProduct(
        val id: Int,
        val sku: Int,
        val title: String,
        val brand: String,
        val price: Double,
        val image: String,
        val reevoo_score: Double,
        val reevoo_count: Int,
        val discount: String,
        val short_description: String
) : Parcelable