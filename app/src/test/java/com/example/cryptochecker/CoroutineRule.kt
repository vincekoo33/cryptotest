package com.example.cryptochecker

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class CoroutineRule : TestRule {

    val testCoroutineDispatcher = TestCoroutineDispatcher()
    val testCoroutineScope = TestCoroutineScope()

    override fun apply(base: Statement?, description: Description?): Statement = object :
        Statement() {
        override fun evaluate() {
            try {
                Dispatchers.setMain(testCoroutineDispatcher)
                base?.evaluate()
            } catch (exception: Exception) {
                testCoroutineScope.cleanupTestCoroutines()
            }

        }
    }

    fun testRunBlocking(block: suspend TestCoroutineScope.() -> Unit) {
        testCoroutineScope.runBlockingTest {
            block()
        }
    }
}