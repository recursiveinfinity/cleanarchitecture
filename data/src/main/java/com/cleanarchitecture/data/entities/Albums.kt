package com.cleanarchitecture.data.entities

import com.google.gson.annotations.SerializedName

data class DataAlbum(
        @SerializedName("userId") val name: String? = null,
        @SerializedName("id") val description: String? = null,
        @SerializedName("title") val url: String? = null
)
