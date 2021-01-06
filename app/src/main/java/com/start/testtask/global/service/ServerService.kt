package com.start.testtask.global.service

import com.google.gson.JsonObject
import com.start.testtask.global.service.Endpoints
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.*

interface ServerService {



    @Headers("Content-Type: application/json")
    @POST(Endpoints.REGISTRATION)
    fun REGISTRATION(
        @Body body: JsonObject
    ): Single<Response<JsonObject>>


    @GET(Endpoints.GET_INFO)
    fun getInfo(
        @Path("username") username : String
    ): Single<Response<JsonObject>>

}