package com.cleanarchitecture.data.entities

import com.google.gson.annotations.SerializedName

data class DataAlbum(
        @SerializedName("userId") var name: String? = null,
        @SerializedName("id") var description: String? = null,
        @SerializedName("title") var url: String? = null
)
