package com.start.testtask.main.presentation.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.start.testtask.R
import com.start.testtask.global.extension.replaceFragment
import com.start.testtask.global.extension.visible
import com.start.testtask.main.di.MainScope
import com.start.testtask.main.presentation.main.MainFragment
import com.start.testtask.main.presentation.registration.RegistrationFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.getKoin
import org.koin.core.qualifier.named

class MainActivity : AppCompatActivity(), MainActivityView {

    private val TAG = "MainActivity"

    @InjectPresenter
    lateinit var presenter: MainActivityPresenter

    @ProvidePresenter
    fun providePresenter(): MainActivityPresenter {
        return getKoin().getOrCreateScope(MainScope.MAIN_ACTIVITY_SCOPE, named(MainScope.MAIN_ACTIVITY_SCOPE)).get()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        setUp()

        onNewIntent(intent)



    }

    private fun setUp(){
        Log.i(TAG, "setup1")
        supportFragmentManager.replaceFragment(
            R.id.container_fragment,
            MainFragment.newInstance(),
            MainFragment.TAG
        )

    }


    override fun showProgressBar(show: Boolean) = progressBar.visible(show)

}
