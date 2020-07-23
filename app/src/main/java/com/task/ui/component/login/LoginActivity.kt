package com.task.ui.component.login

import android.content.Intent
import android.view.View
import com.task.data.Resource
import com.task.databinding.LoginActivityBinding
import com.task.ui.ViewModelFactory
import com.task.ui.base.BaseActivity
import com.task.ui.component.main.MainActivity
import com.task.ui.component.news.NewsListActivity
import com.task.utils.EspressoIdlingResource
import com.task.utils.observe
import com.task.utils.toGone
import com.task.utils.toVisible
import javax.inject.Inject

class LoginActivity : BaseActivity() {
    private lateinit var binding: LoginActivityBinding

    @Inject
    lateinit var loginViewModel: LoginViewModel
    @Inject
    lateinit var viewmodelFactory: ViewModelFactory
    override fun initializeViewModel() {
        loginViewModel = viewmodelFactory.create(LoginViewModel::class.java)
    }

    override fun observeViewModel() {
        observe(loginViewModel.loginLiveData, ::handleLoginResponse)
    }

    override fun initViewBinding() {
        binding = LoginActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun initControl() {
        binding.btnLogin.setOnClickListener {
            loginViewModel.login("binh", "123456")
        }
    }

    private fun handleLoginResponse(result: Resource<Any>) {
        when (result){
            is Resource.Loading -> showLoadingView()
            is Resource.Success -> {
                hideLoadingView()
                gotoMainScreen()
            }
            is Resource.DataError -> {
                hideLoadingView()
            }
        }
    }

    private fun showLoadingView() {
        binding.loadingPgb.toVisible()
        EspressoIdlingResource.increment()
    }

    private fun hideLoadingView() {
        binding.loadingPgb.toGone()
        EspressoIdlingResource.increment()
    }

    private fun gotoMainScreen() {
        val intent = Intent(this, MainActivity::class.java);
        startActivity(intent)
        finish()
    }

}