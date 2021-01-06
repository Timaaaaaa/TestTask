package com.start.testtask.main.repository


import com.google.gson.JsonObject
import com.start.testtask.global.service.ServerService
import io.reactivex.Single
import retrofit2.Response

class UserRepositoryImpl(
    private val serverService: ServerService
): UserRepository {


    override fun registration(user : JsonObject): Single<Response<JsonObject>> =
        serverService.REGISTRATION(body = user)

    override fun getInfo(username : String): Single<Response<JsonObject>> =
        serverService.getInfo(username = username)


}