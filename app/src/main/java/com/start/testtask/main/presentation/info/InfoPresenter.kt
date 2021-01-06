package com.start.testtask.main.presentation.info

import android.util.Log
import android.util.Patterns
import com.arellomobile.mvp.InjectViewState
import com.google.gson.JsonObject
import com.start.testtask.global.presentation.BasePresenter
import com.start.testtask.main.interactor.UserInteractor
import org.json.JSONObject


@Suppress("NAME_SHADOWING")
@InjectViewState
class InfoPresenter(
    private val userInteractor: UserInteractor
): BasePresenter<InfoView>() {

    val TAG = "LessonsMainPresenter"


    fun getData(username : String){

        userInteractor.getInfo(username = username).subscribe({
            Log.i(TAG, "setup3")
            Log.i(TAG, it.message().toString())
            when(it.code()){

                200->{
                    it.body()?.let {it1 ->
                       viewState.showMess(it.body().toString())

                    }
                }
                else->{

                }
            }
        },{
            Log.i(TAG, it.message.toString())
        }).connect()
    }

    fun CharSequence?.isValidEmail() = !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

}