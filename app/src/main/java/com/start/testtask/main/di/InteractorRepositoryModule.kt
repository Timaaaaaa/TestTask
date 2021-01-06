package com.start.testtask.main.di

import com.start.testtask.main.interactor.UserInteractor
import com.start.testtask.main.repository.UserRepository
import com.start.testtask.main.repository.UserRepositoryImpl
import org.koin.dsl.module

val interactorRepositoryModule = module {
    single<UserRepository> { UserRepositoryImpl(get()) }
    single { UserInteractor(get(), get()) }
}