package com.cleanarchitecture.domain.common

/**
 * An abstract class to convert an object of one type to another type
 * @param T - object to be converted
 * @param E - resulting object after conversion
 */
abstract class Mapper<in T, E> {
    abstract fun toUi(from: T): E
}