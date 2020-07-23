package com.task.ui.component.main

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.task.R
import com.task.databinding.MainActivityBinding
import com.task.ui.base.BaseActivity
import javax.inject.Inject


class MainActivity : BaseActivity() {


    private lateinit var binding: MainActivityBinding

    override fun initializeViewModel() {

    }

    override fun observeViewModel() {

    }

    override fun initViewBinding() {
        binding = MainActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setUpNavigation()
    }

    override fun initControl() {

    }

    fun setUpNavigation() {
        val navHostFragment = supportFragmentManager
                .findFragmentById(R.id.mainHostFragment) as NavHostFragment?
        if (navHostFragment != null) {
            NavigationUI.setupWithNavController(binding.bottomNavigationView,
                    navHostFragment.navController)
        }
    }
}