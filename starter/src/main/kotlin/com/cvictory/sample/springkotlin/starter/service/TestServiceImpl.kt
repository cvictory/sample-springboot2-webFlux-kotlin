package com.cvictory.sample.springkotlin.starter.service

import com.cvictory.sample.springkotlin.starter.model.TestModel
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux
import reactor.core.publisher.toMono
import java.util.concurrent.ConcurrentHashMap

/**
 * @author cvictory ON 2018/3/7
 */
@Component
class TestServiceImpl : TestService {
    companion object {
        val initialCustomers = arrayOf(TestModel(1, "Kotlin"),
                TestModel(2, "Spring"),
                TestModel(3, "Microservice", TestModel.Telephone("+44", "7123456789")))
    }
    val customers = ConcurrentHashMap<Int,
            TestModel>(initialCustomers.associateBy(TestModel::id))


    override fun getCustomer(id: Int): Mono<TestModel> = (customers[id] as TestModel).toMono();

    override fun searchCustomers(nameFilter: String): Flux<TestModel> =
            customers.filter {
                it.value.name.contains(nameFilter, true)
            }.map(Map.Entry<Int, TestModel>::value).toList().toFlux();
}
