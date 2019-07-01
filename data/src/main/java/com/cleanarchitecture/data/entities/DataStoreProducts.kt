package com.cleanarchitecture.data.entities

import com.google.gson.annotations.SerializedName

data class DataProducts(
        @SerializedName("payload")
        var payload: List<DataProduct>? = null
)

data class DataProduct(
//TODO: Check for information on the Any data types
        @SerializedName("id")
        var id: String? = null,
        @SerializedName("sku")
        var sku: String? = null,
        @SerializedName("label")
        var label: String? = null,
        @SerializedName("link")
        var link: String? = null,
        @SerializedName("fullDescription")
        var fullDescription: String? = null,
        @SerializedName("brand")
        var brand: DataBrand? = null,
        @SerializedName("boxType")
        var boxType: String? = null,
        @SerializedName("isOnline")
        var isOnline: Boolean? = null,
        @SerializedName("subProducts")
        var subProducts: Any? = null,
        @SerializedName("images")
        var images: List<DataImage>? = null,
        @SerializedName("mainFeatures")
        var mainFeatures: List<String>? = null,
        @SerializedName("categorisation")
        var categorisation: DataCategorisation? = null,
        @SerializedName("externalCategorisation")
        var externalCategorisation: DataExternalCategorisation? = null,
        @SerializedName("price")
        var price: DataPrice? = null,
        @SerializedName("wasPrice")
        var wasPrice: DataWasPrice? = null,
        @SerializedName("priceInBundle")
        var priceInBundle: DataPriceInBundle? = null,
        @SerializedName("preOrder")
        var preOrder: DataPreOrder? = null,
        @SerializedName("forwardOrder")
        var forwardOrder: DataForwardOrder? = null,
        @SerializedName("deliveryOptions")
        var deliveryOptions: List<DataDeliveryOption>? = null,
        @SerializedName("energyEfficiency")
        var energyEfficiency: Any? = null,
        @SerializedName("icons")
        var icons: List<Any>? = null,
        @SerializedName("badges")
        var badges: List<DataBadges>? = null,
        @SerializedName("customerReview")
        var customerReview: DataCustomerReview? = null
)

data class DataBrand(
        @SerializedName("id")
        var id: String? = null,
        @SerializedName("label")
        var label: String? = null

)

data class DataBadges(
        @SerializedName("name")
        var name: String? = null,
        @SerializedName("link")
        var link: String? = null,
        @SerializedName("imageUrl")
        var imageUrl: String? = null

)

data class DataCategorisation(
        @SerializedName("universeId")
        var universeId: String? = null,
        @SerializedName("categoryId")
        var categoryId: String? = null,
        @SerializedName("marketId")
        var marketId: String? = null,
        @SerializedName("segmentId")
        var segmentId: String? = null

)

data class DataCustomerReview(
        @SerializedName("number")
        var number: Int? = null,
        @SerializedName("averageScore")
        var averageScore: Double? = null
)

data class DataDeliveryOption(
        @SerializedName("id")
        var id: String? = null,
        @SerializedName("label")
        var label: String? = null,
        @SerializedName("enabled")
        var enabled: Boolean? = null
)

data class DataExternalCategorisation(
        @SerializedName("planningGroup")
        var planningGroup: DataPlanningGroup? = null,
        @SerializedName("subPlanningGroup")
        var subPlanningGroup: DataSubPlanningGroup? = null,
        @SerializedName("merchandiseArea")
        var merchandiseArea: DataMerchandiseArea? = null
)

data class DataForwardOrder(
        @SerializedName("available")
        var available: Boolean? = null,
        @SerializedName("message")
        var message: Any? = null
)

data class DataImage(
        @SerializedName("url")
        var url: String? = null,
        @SerializedName("urlSizeMedium")
        var urlSizeMedium: String? = null
)

data class DataMerchandiseArea(
        @SerializedName("id")
        var id: String? = null,
        @SerializedName("label")
        var label: String? = null
)





data class DataPlanningGroup(
        @SerializedName("id")
        var id: String? = null,
        @SerializedName("label")
        var label: String? = null
)

data class DataPreOrder(

        @SerializedName("available")
        var available: Boolean? = null,
        @SerializedName("message")
        var message: Any? = null
)

data class DataPrice(

        @SerializedName("amount")
        var amount: Int? = null,
        @SerializedName("vatAmount")
        var vatAmount: Int? = null,
        @SerializedName("currencyCode")
        var currencyCode: String? = null,
        @SerializedName("discountAmount")
        var discountAmount: Int? = null
)

data class DataPriceInBundle(

        @SerializedName("amount")
        var amount: Int? = null,
        @SerializedName("vatAmount")
        var vatAmount: Int? = null,
        @SerializedName("currencyCode")
        var currencyCode: String? = null
)

data class DataSubPlanningGroup(
        @SerializedName("id")
        var id: String? = null,
        @SerializedName("label")
        var label: String? = null
)

data class DataWasPrice(
        @SerializedName("amount")
        var amount: Int? = null,
        @SerializedName("vatAmount")
        var vatAmount: Int?,
        @SerializedName("currencyCode")
        var currencyCode: String?,
        @SerializedName("dateFrom")
        var dateFrom: String? = null,
        @SerializedName("dateTo")
        var dateTo: String? = null,
        @SerializedName("discountAmount")
        var discountAmount: Int? = null

)