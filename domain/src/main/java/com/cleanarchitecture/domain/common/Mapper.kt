package com.cleanarchitecture.domain.common

abstract class Mapper<in T, E> {
    abstract fun toUi(from: T): E
}