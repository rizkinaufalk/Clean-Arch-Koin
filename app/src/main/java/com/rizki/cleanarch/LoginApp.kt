package com.rizki.cleanarch

import android.app.Application
import androidx.multidex.MultiDex
import com.rizki.cleanarch.di.AppModule
import com.rizki.cleanarch.di.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class LoginApp : Application() {

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@LoginApp)
            modules(listOf(AppModule, NetworkModule))
        }

    }
}