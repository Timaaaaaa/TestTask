package com.start.testtask.main.presentation.registration

import android.os.Bundle
import android.util.Log
import androidx.core.text.isDigitsOnly
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.start.testtask.R
import com.start.testtask.global.base.BaseFragment
import com.start.testtask.main.di.MainScope
import kotlinx.android.synthetic.main.registr_fragment.*
import org.koin.android.ext.android.getKoin
import org.koin.core.qualifier.named
import org.koin.ext.isInt

class RegistrationFragment : BaseFragment(), RegistrationView {

    override val layoutRes: Int = R.layout.registr_fragment

    companion object {

        val TAG = "LessonsMainFragment"
        val VARAINT_OF_SHOW = "VARAINT_OF_SHOW"

        fun newInstance() : RegistrationFragment {
            val fragment = RegistrationFragment()

            return fragment
        }

    }

    @InjectPresenter
    lateinit var presenter: RegistrationPresenter

    @ProvidePresenter
    fun providePresenter(): RegistrationPresenter {
        return getKoin().getOrCreateScope(MainScope.REGISTRATION_SCOPE, named(MainScope.REGISTRATION_SCOPE)).get()
    }

    override fun onDestroy() {
        getKoin().getScopeOrNull(MainScope.REGISTRATION_SCOPE)?.close()
        super.onDestroy()
    }


    override fun setUp(savedInstanceState: Bundle?) {
        Log.i(TAG, "setup")


        btnSignInAuth.setOnClickListener {
            if(!edtStatusAuth.text.toString().isInt()){
                return@setOnClickListener
                showMess("статус должен быть числом")
            }
            presenter.getData(edtLoginAuth.text.toString(),
                edtNameAuth.text.toString(),
                edtLastNameAuth.text.toString(),
                edtMailAuth.text.toString(),
                edtPasswordAuth.text.toString(),
                edtPhoneAuth.text.toString(),
                edtStatusAuth.text.toString().toInt())
        }


    }

    override fun showMess(mess : String){
        showMessage(mess, requireView())
    }

}
