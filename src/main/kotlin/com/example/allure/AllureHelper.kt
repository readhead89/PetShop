package com.example.allure

import io.qameta.allure.Allure

object AllureHelper {
    fun allureStep(name: String, block: () -> Unit) {
        Allure.step(name, block)
    }
}