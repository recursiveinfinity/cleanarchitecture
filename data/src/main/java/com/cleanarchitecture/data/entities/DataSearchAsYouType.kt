package com.cleanarchitecture.data.entities

import com.google.gson.annotations.SerializedName


data class DataSearchAsYouType(
        @SerializedName("General")
        var general: DataSearchAsYouTypeGeneral? = null,
        @SerializedName("Results")
        var results: List<DataSearchAsYouTypeResult>? = null
)

data class DataSearchAsYouTypeGeneral(
        @SerializedName("query") val query: String,
        @SerializedName("sayt_q") val sayt_q: String,
        @SerializedName("total") val total: String,
        @SerializedName("page_lower") val page_lower: String,
        @SerializedName("page_upper") val page_upper: String,
        @SerializedName("index") val index: String
)

data class DataSearchAsYouTypeResult(
        @SerializedName("id") val id: String,
        @SerializedName("title") val title: String,
        @SerializedName("url") val url: String,
        @SerializedName("image") val image: String,
        @SerializedName("brand") val brand: String,
        @SerializedName("price") val price: String,
        @SerializedName("review_score") val review_score: String,
        @SerializedName("number_of_reviews") val number_of_reviews: String
)