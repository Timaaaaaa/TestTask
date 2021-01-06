package com.start.testtask.main.presentation.info

import android.os.Bundle
import android.util.Log
import androidx.core.text.isDigitsOnly
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.start.testtask.R
import com.start.testtask.global.base.BaseFragment
import com.start.testtask.global.utils.LocalStorage
import com.start.testtask.main.di.MainScope
import kotlinx.android.synthetic.main.info_fragment.*
import kotlinx.android.synthetic.main.registr_fragment.*
import org.koin.android.ext.android.getKoin
import org.koin.core.qualifier.named
import org.koin.ext.isInt

class InfoFragment : BaseFragment(), InfoView {

    override val layoutRes: Int = R.layout.info_fragment

    companion object {

        val TAG = "LessonsMainFragment"
        val VARAINT_OF_SHOW = "VARAINT_OF_SHOW"

        fun newInstance() : InfoFragment {
            val fragment = InfoFragment()

            return fragment
        }

    }

    @InjectPresenter
    lateinit var presenter: InfoPresenter

    @ProvidePresenter
    fun providePresenter(): InfoPresenter {
        return getKoin().getOrCreateScope(MainScope.INFO_SCOPE, named(MainScope.INFO_SCOPE)).get()
    }

    override fun onDestroy() {
        getKoin().getScopeOrNull(MainScope.INFO_SCOPE)?.close()
        super.onDestroy()
    }


    override fun setUp(savedInstanceState: Bundle?) {
        Log.i(TAG, "setup")


        btnInfo.setOnClickListener {
            presenter.getData(edtLogin.text.toString())
        }

        if(LocalStorage.getAuthor()!="noname"){
            text.text = LocalStorage.getAuthor()
        }
    }

    override fun showMess(mess : String){
        text.text = mess
        LocalStorage.setAuthor(mess)
        showMessage(mess, requireView())
    }

}
