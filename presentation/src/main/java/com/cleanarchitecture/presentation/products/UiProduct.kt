package com.cleanarchitecture.presentation.products

data class UiProducts(
        var products: List<UiProduct>? = null
)

data class UiProduct(
        var id: String? = null,
        var sku: String? = null,
        var label: String? = null,
        var link: String? = null,
        var fullDescription: String? = null,
        var brand: UiBrand? = null,
        var boxType: String? = null,
        var isOnline: Boolean? = null,
        var subProducts: Any? = null,
        var images: List<UiImage>? = null,
        var mainFeatures: List<String>? = null,
        var categorisation: UiCategorisation? = null,
        var externalCategorisation: UiExternalCategorisation? = null,
        var price: UiPrice? = null,
        var wasPrice: UiWasPrice? = null,
        var priceInBundle: UiPriceInBundle? = null,
        var preOrder: UiPreOrder? = null,
        var forwardOrder: UiForwardOrder? = null,
        var deliveryOptions: List<UiDeliveryOption>? = null,
        var energyEfficiency: Any? = null,
        var icons: List<Any>? = null,
        var badges: List<Any>? = null,
        var customerReview: UiCustomerReview? = null
)

data class UiBrand(
        var id: String? = null,
        var label: String? = null
)

data class UiCategorisation(
        var universeId: String? = null,
        var categoryId: String? = null,
        var marketId: String? = null,
        var segmentId: String? = null
)

data class UiCustomerReview(
        var number: Int? = null,
        var averageScore: Double? = null
)

data class UiDeliveryOption(
        var id: String? = null,
        var label: String? = null,
        var enabled: Boolean? = null
)

data class UiExternalCategorisation(
        var planningGroup: UiPlanningGroup? = null,
        var subPlanningGroup: UiSubPlanningGroup? = null,
        var merchandiseArea: UiMerchandiseArea? = null
)

data class UiForwardOrder(
        var available: Boolean? = null,
        var message: Any? = null
)

data class UiImage(
        var url: String? = null,
        var urlSizeMedium: String? = null
)

data class UiMerchandiseArea(
        var id: String? = null,
        var label: String? = null
)

data class UiPlanningGroup(
        var id: String? = null,
        var label: String? = null
)

data class UiPreOrder(
        var available: Boolean? = null,
        var message: Any? = null
)

data class UiPrice(
        var amount: Int? = null,
        var vatAmount: Int? = null,
        var currencyCode: String? = null,
        var discountAmount: Int? = null
)

data class UiPriceInBundle(
        var amount: Int? = null,
        var vatAmount: Int? = null,
        var currencyCode: String? = null
)

data class UiSubPlanningGroup(
        var id: String? = null,
        var label: String? = null
)

data class UiWasPrice(
        var amount: Int? = null,
        var vatAmount: Int? = null,
        var currencyCode: String? = null,
        var dateFrom: String? = null,
        var dateTo: String? = null,
        var discountAmount: String? = null
)
