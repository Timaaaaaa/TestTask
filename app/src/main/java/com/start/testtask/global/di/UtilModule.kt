package com.start.testtask.global.di


import com.start.testtask.global.functional.NetworkHandler
import com.start.testtask.global.system.AppSchedulers
import com.start.testtask.global.system.ResourceManager
import com.start.testtask.global.system.SchedulersProvider
import com.start.testtask.global.utils.ErrorHandler
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val utilModule = module {
    single { AppSchedulers() as SchedulersProvider }
    single { ResourceManager(androidContext()) }
    single { ErrorHandler(get()) }
    single { NetworkHandler(androidContext()) }
}