package com.rizki.cleanarch.data.repository

import com.android.post.di.module.NetworkModule
import com.android.post.di.module.PostModule
import org.junit.Test
import org.koin.core.logger.Level
import org.koin.dsl.koinApplication
import org.koin.test.AutoCloseKoinTest
import org.koin.test.check.checkModules

class KoinModuleTest : AutoCloseKoinTest() {

    @Test
    fun testCoreModule() {
        koinApplication {
            printLogger(Level.DEBUG)
            modules(listOf(PostModule, NetworkModule))
        }.checkModules()
    }

}