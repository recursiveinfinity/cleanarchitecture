package com.cleanarchitecture.domain.products


data class DomainProducts(
        var products: List<DomainProduct>? = null
)

data class DomainProduct(
//TODO: Check for information on the Any data types
        var id: String? = null,
        var sku: String? = null,
        var label: String? = null,
        var link: String? = null,
        var fullDescription: String? = null,
        var brand: DomainBrand? = null,
        var boxType: String? = null,
        var isOnline: Boolean? = null,
        var subProducts: Any? = null,
        var images: List<DomainImage>? = null,
        var mainFeatures: List<String>? = null,
        var categorisation: DomainCategorisation? = null,
        var externalCategorisation: DomainExternalCategorisation? = null,
        var price: DomainPrice? = null,
        var wasPrice: Any? = null,
        var priceInBundle: DomainPriceInBundle? = null,
        var preOrder: DomainPreOrder? = null,
        var forwardOrder: DomainForwardOrder? = null,
        var deliveryOptions: List<DomainDeliveryOption>? = null,
        var energyEfficiency: Any? = null,
        var icons: List<Any>? = null,
        var badges: List<Any>? = null,
        var customerReview: DomainCustomerReview? = null
)

data class DomainBrand(
        var id: String? = null,
        var label: String? = null
)

data class DomainCategorisation(
        var universeId: String? = null,
        var categoryId: String? = null,
        var marketId: String? = null,
        var segmentId: String? = null
)

data class DomainCustomerReview(
        var number: Int? = null,
        var averageScore: Double? = null
)

data class DomainDeliveryOption(
        var id: String? = null,
        var label: String? = null,
        var enabled: Boolean? = null
)

data class DomainExternalCategorisation(
        var planningGroup: DomainPlanningGroup? = null,
        var subPlanningGroup: DomainSubPlanningGroup? = null,
        var merchandiseArea: DomainMerchandiseArea? = null
)

data class DomainForwardOrder(
        var available: Boolean? = null,
        var message: Any? = null
)

data class DomainImage(
        var url: String? = null,
        var urlSizeMedium: String? = null
)

data class DomainMerchandiseArea(
        var id: String? = null,
        var label: String? = null
)

data class DomainPlanningGroup(
        var id: String? = null,
        var label: String? = null
)

data class DomainPreOrder(
        var available: Boolean? = null,
        var message: Any? = null
)

data class DomainPrice(
        var amount: Int? = null,
        var vatAmount: Int? = null,
        var currencyCode: String? = null,
        var discountAmount: Int? = null
)

data class DomainPriceInBundle(
        var amount: Int? = null,
        var vatAmount: Int? = null,
        var currencyCode: String? = null
)

data class DomainSubPlanningGroup(
        var id: String? = null,
        var label: String? = null
)

data class DomainWasPrice(
        var amount: Int? = null,
        var vatAmount: Int? = null,
        var currencyCode: String? = null,
        var dateFrom: Int? = null,
        var dateTo: Int? = null,
        var discountAmount: Int? = null
)