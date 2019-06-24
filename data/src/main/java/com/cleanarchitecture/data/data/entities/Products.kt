package com.cleanarchitecture.data.entities

import com.google.gson.annotations.SerializedName

data class DataProduct(
        @SerializedName("productId") val name: String? = null,
        val description: String? = null,
        val url: String? = null,
        val price: String? = null,
        val ratings: Float? = null,
        val reviewCount: Int? = null
)



