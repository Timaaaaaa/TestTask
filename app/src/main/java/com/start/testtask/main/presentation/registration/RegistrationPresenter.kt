package com.start.testtask.main.presentation.registration

import android.util.Log
import android.util.Patterns
import com.arellomobile.mvp.InjectViewState
import com.google.gson.JsonObject
import com.start.testtask.global.presentation.BasePresenter
import com.start.testtask.main.interactor.UserInteractor
import org.json.JSONObject


@Suppress("NAME_SHADOWING")
@InjectViewState
class RegistrationPresenter(
    private val userInteractor: UserInteractor
): BasePresenter<RegistrationView>() {

    val TAG = "LessonsMainPresenter"


    fun getData(username : String, firstname : String, lastName : String, mail : String, passWord : String, phone : String, status : Int){

        Log.i(TAG, "setup2")
        val paramObject = JsonObject()
        if(username != ""){
            paramObject.addProperty("username", username)
        }else{
            viewState.showMess("логин не правильный")
            return
        }
        if(firstname!= ""){
            paramObject.addProperty("firstName", firstname)
        }else{
            viewState.showMess("имя не правильное")
            return
        }

        if(lastName!= ""){
            paramObject.addProperty("lastName", lastName)
        }else{
            viewState.showMess("фамилия не правильная")
            return
        }
        if(mail != "" && mail.isValidEmail()){
            paramObject.addProperty("email", mail)
        }else{
            viewState.showMess("почта не правильный")
            return
        }
        if(passWord!= ""){
            paramObject.addProperty("password", passWord)
        }else{
            viewState.showMess("логин не правильный")
            return
        }
        if(phone.length > 10){
            paramObject.addProperty("phone", phone)
        }else{
            viewState.showMess("номер телефона не правильный")
            return
        }


        if(status>(-1) && status <6){
            paramObject.addProperty("userStatus", status)
        }else{
            viewState.showMess("номер телефона не правильный")
            return
        }







        userInteractor.registration(user = paramObject).subscribe({
            Log.i(TAG, "setup3")
            Log.i(TAG, it.message().toString())
            when(it.code()){

                200->{
                    it.body()?.let {it1 ->
                        Log.i("PRESENTERLOG", it1.toString())

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