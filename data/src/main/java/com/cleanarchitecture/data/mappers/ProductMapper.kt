package com.cleanarchitecture.data.mappers

import com.cleanarchitecture.data.entities.*
import com.cleanarchitecture.domain.common.Mapper
import com.cleanarchitecture.domain.products.*


class ProductMapper : Mapper<DataProducts, DomainProducts> {

    override fun map(from: DataProducts): DomainProducts = DomainProducts(
            products = from.payload?.map { toProduct(it) }
    )

    private fun toProduct(product: DataProduct): DomainProduct = DomainProduct(
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
            wasPrice = product.wasPrice,
            priceInBundle = toPriceInBundle(product.priceInBundle),
            preOrder = toPreOrder(product.preOrder),
            forwardOrder = toForwardOrder(product.forwardOrder),
            deliveryOptions = product.deliveryOptions?.map { toDeliveryOptions(it) },
            energyEfficiency = product.energyEfficiency,
            icons = product.icons,
            badges = product.badges,
            customerReview = toCustomerReview(product.customerReview)
    )

    private fun toCustomerReview(customerReview: DataCustomerReview?): DomainCustomerReview? = DomainCustomerReview(
            number = customerReview?.number
    )

    private fun toDeliveryOptions(deliveryOption: DataDeliveryOption): DomainDeliveryOption = DomainDeliveryOption(
            id = deliveryOption.id,
            label = deliveryOption.label,
            enabled = deliveryOption.enabled
    )

    private fun toForwardOrder(forwardOrder: DataForwardOrder?): DomainForwardOrder? = DomainForwardOrder(
            available = forwardOrder?.available,
            message = forwardOrder?.message
    )

    private fun toPreOrder(preOrder: DataPreOrder?): DomainPreOrder? = DomainPreOrder(
            available = preOrder?.available,
            message = preOrder?.message
    )

    private fun toPriceInBundle(priceInBundle: DataPriceInBundle?): DomainPriceInBundle? = DomainPriceInBundle(
            amount = priceInBundle?.amount,
            vatAmount = priceInBundle?.vatAmount,
            currencyCode = priceInBundle?.currencyCode
    )

    private fun toPrice(price: DataPrice?): DomainPrice? = DomainPrice(
            amount = price?.amount,
            vatAmount = price?.vatAmount,
            currencyCode = price?.currencyCode,
            discountAmount = price?.discountAmount
    )

    private fun toExternalCategorisation(externalCategorisation: DataExternalCategorisation?): DomainExternalCategorisation? = DomainExternalCategorisation(
            planningGroup = toPlanningGroup(externalCategorisation?.planningGroup),
            subPlanningGroup = toSubPlanningGroup(externalCategorisation?.subPlanningGroup),
            merchandiseArea = toMerchandiseArea(externalCategorisation?.merchandiseArea)
    )

    private fun toMerchandiseArea(merchandiseArea: DataMerchandiseArea?): DomainMerchandiseArea? = DomainMerchandiseArea(
            id = merchandiseArea?.id,
            label = merchandiseArea?.label
    )

    private fun toSubPlanningGroup(subPlanningGroup: DataSubPlanningGroup?): DomainSubPlanningGroup? = DomainSubPlanningGroup(
            id = subPlanningGroup?.id,
            label = subPlanningGroup?.label
    )

    private fun toPlanningGroup(planningGroup: DataPlanningGroup?): DomainPlanningGroup? = DomainPlanningGroup(
            id = planningGroup?.id,
            label = planningGroup?.label
    )

    private fun toCategorisation(categorisation: DataCategorisation?): DomainCategorisation? = DomainCategorisation(
            universeId = categorisation?.universeId,
            categoryId = categorisation?.categoryId,
            marketId = categorisation?.marketId,
            segmentId = categorisation?.segmentId
    )

    private fun toImages(image: DataImage): DomainImage = DomainImage(
            url = image.url,
            urlSizeMedium = image.urlSizeMedium
    )

    private fun toBrand(brand: DataBrand?): DomainBrand? = DomainBrand(
            id = brand?.id,
            label = brand?.label
    )
}



