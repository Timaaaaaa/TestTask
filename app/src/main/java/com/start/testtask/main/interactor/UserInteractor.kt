package com.start.testtask.main.interactor

import com.google.gson.JsonObject
import com.start.testtask.global.system.SchedulersProvider
import com.start.testtask.main.repository.UserRepository
import io.reactivex.Single
import retrofit2.Response

class UserInteractor(
    private val userRepository: UserRepository,
    private val schedulersProvider: SchedulersProvider
){


    fun registration(user : JsonObject): Single<Response<JsonObject>> =
        userRepository.registration(user = user)
            .subscribeOn(schedulersProvider.io())
            .observeOn(schedulersProvider.ui())

    fun getInfo(username : String): Single<Response<JsonObject>> =
        userRepository.getInfo(username = username)
            .subscribeOn(schedulersProvider.io())
            .observeOn(schedulersProvider.ui())


}