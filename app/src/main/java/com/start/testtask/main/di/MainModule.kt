package com.start.testtask.main.di

import com.start.testtask.main.presentation.activity.MainActivityPresenter
import com.start.testtask.main.presentation.info.InfoPresenter
import com.start.testtask.main.presentation.registration.RegistrationPresenter
import org.koin.core.qualifier.named
import org.koin.dsl.module

val mainModule = module {

    scope(named(MainScope.MAIN_ACTIVITY_SCOPE)) {
        scoped { MainActivityPresenter(get()) }
    }
    scope(named(MainScope.REGISTRATION_SCOPE)) {
        scoped { RegistrationPresenter(get()) }
    }
    scope(named(MainScope.INFO_SCOPE)) {
        scoped { InfoPresenter(get()) }
    }
}


object MainScope {
    const val MAIN_ACTIVITY_SCOPE = "MainActivityScope"
    const val REGISTRATION_SCOPE = "RegistrationScope"
    const val INFO_SCOPE = "InfoScope"

}
