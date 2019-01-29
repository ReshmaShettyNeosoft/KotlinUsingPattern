package com.droidipc.kotlinusingpattern

import android.app.Application
import android.content.Context

open class KotlinUsingPatternApplication : Application() {
    var context: Context? = null
    var resourceProvider: ResourceProvider? = null

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    fun getResourceProviderObj(): ResourceProvider{
        resourceProvider = ResourceProvider(this)
        return resourceProvider as ResourceProvider
    }
}