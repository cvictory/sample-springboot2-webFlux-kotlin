package com.cvictory.sample.springkotlin.starter.controller.rest

import com.cvictory.sample.springkotlin.starter.model.TestModel
import com.cvictory.sample.springkotlin.starter.service.TestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

/**
 * @author cvictory ON 2018/3/7
 */

@RestController
class TestController {

    @Autowired
    private lateinit var testService: TestService;

    @GetMapping(value = "/customer/{id}")
    fun getCustomer(@PathVariable id: Int) = TestModel(id, "customer $id")

    @GetMapping(value = "/customer/new/{id}")
    fun getNewCustomer(@PathVariable id: Int): ResponseEntity<Mono<TestModel>> {
        return ResponseEntity(testService.getCustomer(id), HttpStatus.OK)
    }

    @GetMapping(value = "/customers")
    fun getCustomers(@RequestParam(required = false, defaultValue = "")
                     nameFilter: String) =
            ResponseEntity(testService.searchCustomers(nameFilter), HttpStatus.OK);

}