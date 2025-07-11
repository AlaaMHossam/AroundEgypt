package com.alaa.hossam.aroundegypt.ui

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

@OptIn(ExperimentalCoroutinesApi::class)
class MainDispatcherRule(private val testDispatcherRule: TestDispatcher = StandardTestDispatcher()) :
    TestWatcher() {
    override fun starting(description: Description?) = Dispatchers.setMain(testDispatcherRule)
    override fun finished(description: Description?) = Dispatchers.resetMain()
}