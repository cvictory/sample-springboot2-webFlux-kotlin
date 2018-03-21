package com.cvictory.sample.springkotlin.starter.service

import com.cvictory.sample.springkotlin.starter.model.TestModel
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * @author cvictory ON 2018/3/7
 */

interface TestService {
    fun getCustomer(id: Int) : Mono<TestModel>
    fun searchCustomers(nameFilter: String): Flux<TestModel>
}