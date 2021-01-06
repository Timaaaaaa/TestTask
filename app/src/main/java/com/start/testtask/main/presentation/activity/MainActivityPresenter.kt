package com.start.testtask.main.presentation.activity

import android.util.Log
import androidx.fragment.app.Fragment
import com.arellomobile.mvp.InjectViewState
import com.start.testtask.global.presentation.BasePresenter
import com.start.testtask.global.utils.LocalStorage
import com.start.testtask.main.interactor.UserInteractor

@InjectViewState
class MainActivityPresenter( private val userInteractor: UserInteractor): BasePresenter<MainActivityView>() {

    val TAG = "MainActivityPresenter"

    fun onFragmentAttach(fragment: Fragment){
        Log.i(TAG, fragment.tag)
    }

    fun onFragmentDetach(fragment: Fragment){

    }



}