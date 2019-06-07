package com.cleanarchitecture.domain.common

abstract class Mapper<in T, E> {
    abstract fun toUiList(from: T): E
}