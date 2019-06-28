package com.cleanarchitecture.presentation.products

import com.cleanarchitecture.domain.common.Mapper
import com.cleanarchitecture.domain.products.*

class UiProductMapper : Mapper<DomainProducts, UiProducts> {

    override fun map(from: DomainProducts): UiProducts = UiProducts(
            products = from.products?.map { toProduct(it) }
    )

    fun toProduct(product: DomainProduct): UiProduct = UiProduct(
            id = product.id,
            sku = product.sku,
            label = product.label,
            link = product.link,
            fullDescription = product.fullDescription,
            brand = toBrand(product.brand),
            boxType = product.boxType,
            isOnline = product.isOnline,
            subProducts = product.subProducts,
            images = product.images?.map { toImages(it) },
            mainFeatures = product.mainFeatures,
            categorisation = toCategorisation(product.categorisation),
            externalCategorisation = toExternalCategorisation(product.externalCategorisation),
            price = toPrice(product.price),
            wasPrice = toWasPrice(product.wasPrice),
            priceInBundle = toPriceInBundle(product.priceInBundle),
            preOrder = toPreOrder(product.preOrder),
            forwardOrder = toForwardOrder(product.forwardOrder),
            deliveryOptions = product.deliveryOptions?.map { toDeliveryOptions(it) },
            energyEfficiency = product.energyEfficiency,
            icons = product.icons,
            badges = product.badges,
            customerReview = toCustomerReview(product.customerReview)
    )

    private fun toWasPrice(wasPrice: DomainWasPrice?): UiWasPrice? = UiWasPrice(
            amount = wasPrice?.amount,
            vatAmount = wasPrice?.vatAmount,
            currencyCode = wasPrice?.currencyCode,
            dateFrom = wasPrice?.dateFrom,
            dateTo = wasPrice?.dateTo,
            discountAmount = wasPrice?.discountAmount
    )

    private fun toCustomerReview(customerReview: DomainCustomerReview?): UiCustomerReview? = UiCustomerReview(
            number = customerReview?.number,
            averageScore = customerReview?.averageScore
    )

    private fun toDeliveryOptions(deliveryOption: DomainDeliveryOption): UiDeliveryOption = UiDeliveryOption(
            id = deliveryOption.id,
            label = deliveryOption.label,
            enabled = deliveryOption.enabled
    )

    private fun toForwardOrder(forwardOrder: DomainForwardOrder?): UiForwardOrder? = UiForwardOrder(
            available = forwardOrder?.available,
            message = forwardOrder?.message
    )

    private fun toPreOrder(preOrder: DomainPreOrder?): UiPreOrder? = UiPreOrder(
            available = preOrder?.available,
            message = preOrder?.message
    )

    private fun toPriceInBundle(priceInBundle: DomainPriceInBundle?): UiPriceInBundle? = UiPriceInBundle(
            amount = priceInBundle?.amount,
            vatAmount = priceInBundle?.vatAmount,
            currencyCode = priceInBundle?.currencyCode
    )

    private fun toPrice(price: DomainPrice?): UiPrice? = UiPrice(
            amount = price?.amount,
            vatAmount = price?.vatAmount,
            currencyCode = price?.currencyCode,
            discountAmount = price?.discountAmount
    )

    private fun toExternalCategorisation(externalCategorisation: DomainExternalCategorisation?): UiExternalCategorisation? = UiExternalCategorisation(
            planningGroup = toPlanningGroup(externalCategorisation?.planningGroup),
            subPlanningGroup = toSubPlanningGroup(externalCategorisation?.subPlanningGroup),
            merchandiseArea = toMerchandiseArea(externalCategorisation?.merchandiseArea)
    )

    private fun toMerchandiseArea(merchandiseArea: DomainMerchandiseArea?): UiMerchandiseArea? = UiMerchandiseArea(
            id = merchandiseArea?.id,
            label = merchandiseArea?.label
    )

    private fun toSubPlanningGroup(subPlanningGroup: DomainSubPlanningGroup?): UiSubPlanningGroup? = UiSubPlanningGroup(
            id = subPlanningGroup?.id,
            label = subPlanningGroup?.label
    )

    private fun toPlanningGroup(planningGroup: DomainPlanningGroup?): UiPlanningGroup? = UiPlanningGroup(
            id = planningGroup?.id,
            label = planningGroup?.label
    )

    private fun toCategorisation(categorisation: DomainCategorisation?): UiCategorisation? = UiCategorisation(
            universeId = categorisation?.universeId,
            categoryId = categorisation?.categoryId,
            marketId = categorisation?.marketId,
            segmentId = categorisation?.segmentId
    )

    private fun toImages(image: DomainImage): UiImage = UiImage(
            url = image.url,
            urlSizeMedium = image.urlSizeMedium
    )

    private fun toBrand(brand: DomainBrand?): UiBrand? = UiBrand(
            id = brand?.id,
            label = brand?.label
    )
}