package com.task.ui.component.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.task.data.DataRepositorySource
import com.task.data.Resource
import com.task.data.error.mapper.ErrorMapper
import com.task.ui.base.BaseViewModel
import com.task.usecase.errors.ErrorManager
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val dataRepositoryRepository: DataRepositorySource): BaseViewModel() {

    override val errorManager: ErrorManager
        get() = ErrorManager(ErrorMapper())

    val loginLiveData = MutableLiveData<Resource<Any>>()

    fun login(userName: String, password: String) {
        viewModelScope.launch {
            loginLiveData.value = Resource.Loading()
            Thread.sleep(5000)
            loginLiveData.value = Resource.Success(Object())
        }
    }

}