package com.calisdiary.api.response


import com.calisdiary.api.request.LoginRequest
import com.calisdiary.api.request.SignUpRequestVendor
import okhttp3.MultipartBody
import retrofit2.Response
import javax.inject.Inject

class Interface_Implement @Inject constructor(private val apiService: Api_Interface){


    suspend fun signInApiVendor(request: SignUpRequestVendor): Response<SignUpResponse> =
        apiService.signInApiVendor(request)



    suspend fun login(request: LoginRequest): Response<LogInResponse> = apiService.login(request)

    suspend fun getAllCountryApi(countryCode: String, stateCode: String): Response<CountryResponse>
    = apiService.getAllCountryApi()




    suspend fun getAllStateApi(countryCode: String): Response<CountryResponse> =
        apiService.getAllStateApi(countryCode)


    suspend fun getAllCityApi(countryCode: String, stateCode: String): Response<CountryResponse> =
        apiService.getAllCityApi(countryCode, stateCode)

    suspend fun uploadMultipleFile(file: ArrayList<MultipartBody.Part>): Response<ImageUploadResponse> =
        apiService.uploadMultipleFile(file)

}