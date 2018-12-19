package com.wtr.core.domain

interface Mapper<From, To> {

    fun transform(from: From): To

    fun transformAll(list: List<From>): List<To> = list.map(::transform)
}