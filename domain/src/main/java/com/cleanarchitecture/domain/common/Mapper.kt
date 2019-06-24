package com.cleanarchitecture.domain.common

/**
 * An interface to convert an object of one type to another type
 * @param T - object to be converted
 * @param R - resulting object after conversion
 */
interface Mapper<in T, R> {
    fun map(from: T): R
    /**
     * Utilises default implementation functionality of Kotlin's interfaces to implement
     * conversion of List of objects of type T using the map methods implementation
     */
    fun mapList(fromList: List<T>): List<R> = fromList.map { map(it) }
}