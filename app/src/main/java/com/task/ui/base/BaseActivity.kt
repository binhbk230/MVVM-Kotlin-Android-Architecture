package com.task.ui.base

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.task.ui.base.listeners.BaseView
import dagger.android.AndroidInjection

/**
 * Created by AhmedEltaher
 */


abstract class BaseActivity : AppCompatActivity(), BaseView {

    protected lateinit var baseViewModel: BaseViewModel

    protected abstract fun initializeViewModel()
    abstract fun observeViewModel()
    protected abstract fun initViewBinding()
    protected abstract fun initControl()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        initViewBinding()
        initializeViewModel()
        initControl()
        observeViewModel()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
