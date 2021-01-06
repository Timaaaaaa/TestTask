package com.start.testtask.main.presentation.main

import android.os.Bundle
import android.util.Log
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.start.testtask.R
import com.start.testtask.global.base.BaseFragment
import com.start.testtask.global.extension.addFragmentWithBackStack
import com.start.testtask.global.extension.replaceFragment
import com.start.testtask.main.di.MainScope
import com.start.testtask.main.presentation.info.InfoFragment
import com.start.testtask.main.presentation.registration.RegistrationFragment
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.android.ext.android.getKoin
import org.koin.core.qualifier.named

class MainFragment : BaseFragment() {

    override val layoutRes: Int = R.layout.main_fragment

    companion object {

        val TAG = "LessonsMainFragment"
        val VARAINT_OF_SHOW = "VARAINT_OF_SHOW"

        fun newInstance() : MainFragment {
            val fragment = MainFragment()

            return fragment
        }

    }






    override fun setUp(savedInstanceState: Bundle?) {
        Log.i(TAG, "setup")

        btnRegMain.setOnClickListener {
            activity?.supportFragmentManager?.addFragmentWithBackStack(
                R.id.container_fragment,
                RegistrationFragment.newInstance(),
                RegistrationFragment.TAG
            )
        }

        btnInfoMain.setOnClickListener {
            activity?.supportFragmentManager?.addFragmentWithBackStack(
                R.id.container_fragment,
                InfoFragment.newInstance(),
                InfoFragment.TAG
            )
        }
    }



}
