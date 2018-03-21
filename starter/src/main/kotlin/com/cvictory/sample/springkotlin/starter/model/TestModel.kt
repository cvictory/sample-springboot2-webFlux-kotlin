package com.cvictory.sample.springkotlin.starter.model

/**
 * @author cvictory ON 2018/3/7
 */
data class TestModel(var id: Int = 0, val name: String = "", val telephone:
Telephone? = null) {
    data class Telephone(var countryCode: String = "", var telephoneNumber:
    String = "")
}