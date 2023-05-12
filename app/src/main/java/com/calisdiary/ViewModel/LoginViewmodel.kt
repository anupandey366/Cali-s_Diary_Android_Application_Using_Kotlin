package com.calisdiary.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.calisdiary.ModalClass.PojoClass
import com.calisdiary.Repository.CalisRespository
import com.calisdiary.Utils.NetworkHelper
import com.calisdiary.Utils.Resource
import com.calisdiary.api.request.LoginRequest
import com.calisdiary.api.response.AddEventResponse
import com.calisdiary.api.response.Constants.NO_INTERNET
import com.calisdiary.api.response.LogInResponse
import com.google.gson.GsonBuilder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class LoginViewmodel@Inject constructor(app: Application, private val repo: CalisRespository, private val networkHelper: NetworkHelper): AndroidViewModel(app) {

    private val loginData: MutableStateFlow<Resource<LogInResponse>> =
        MutableStateFlow(Resource.Empty())
    val _loginData: StateFlow<Resource<LogInResponse>> = loginData

    private val logoutData: MutableStateFlow<Resource<AddEventResponse>> =
        MutableStateFlow(Resource.Empty())
    val _logoutData: MutableStateFlow<Resource<AddEventResponse>> = logoutData

    private val socialLoginData: MutableStateFlow<Resource<LogInResponse>> =
        MutableStateFlow(Resource.Empty())
    val _socialLoginData: StateFlow<Resource<LogInResponse>> = socialLoginData

    //    Login Api


    fun loginApi(request: LoginRequest) = viewModelScope.launch {
        loginData.value = Resource.Loading()

        if (networkHelper.hasInternetConnection()) {

            repo.login(request)
                .catch { e ->
                    loginData.value = Resource.Error(e.message.toString())
                }.collect { data ->
                    loginData.value = loginResponseHandle(data)
                }
        } else {
            loginData.value = Resource.Error(NO_INTERNET)
        }

    }


    private fun loginResponseHandle(response: Response<LogInResponse>): Resource<LogInResponse> {


        if (response.isSuccessful) {
            if (response.isSuccessful) {
                response.body()?.let {
                    return Resource.Success(it)
                }
            }


        }
        val gson = GsonBuilder().create()
        var pojo = PojoClass()

        try {
            pojo = gson.fromJson(response.errorBody()!!.string(), pojo::class.java)

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return Resource.Error(pojo.responseMessage)
    }
}