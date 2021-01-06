package com.start.testtask.main.repository


import android.widget.Button
import com.google.gson.JsonObject
import io.reactivex.Single
import retrofit2.Response

interface UserRepository{

    fun registration(user : JsonObject): Single<Response<JsonObject>>
    fun getInfo(username : String): Single<Response<JsonObject>>
}