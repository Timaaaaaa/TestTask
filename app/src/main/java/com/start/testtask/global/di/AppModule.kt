package com.start.testtask.global.di

import com.start.testtask.main.di.interactorRepositoryModule
import com.start.testtask.main.di.mainModule


val appModule = listOf(
                        networkModule,
                        utilModule,
                        mainModule,
                        interactorRepositoryModule
                        )