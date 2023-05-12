package com.calisdiary.api.response


import com.calisdiary.api.request.LoginRequest
import com.calisdiary.api.request.SignUpRequestVendor
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface Api_Interface {



    @POST("user/signUp")
    suspend fun signInApiVendor(@Body request: SignUpRequestVendor): Response<SignUpResponse>

//    @POST("user/signUp")
//    suspend fun signInApiVendor(@Body request: SignUpRequestVendor): Response<SignUpResponse>
//
//
//    @GET("user/getAllCountry")
//    suspend fun getAllCountryApi(): Response<CountryResponse>
//
//    @GET("user/getAllState")
//    suspend fun getAllStateApi(@Query("countryCode") countryCode: String): Response<CountryResponse>

    @POST("user/login")
    suspend fun login(@Body request: LoginRequest): Response<LogInResponse>


    @GET("user/getAllCountry")
    suspend fun getAllCountryApi(): Response<CountryResponse>

    @GET("user/getAllState")
    suspend fun getAllStateApi(@Query("countryCode") countryCode: String): Response<CountryResponse>


    @GET("user/getAllCity")
    suspend fun getAllCityApi(
        @Query("countryCode") countryCode: String,
        @Query("stateCode") stateCode: String
    ): Response<CountryResponse>

    @Multipart
    @POST("post/uploadMultipleFile")
    suspend fun uploadMultipleFile(@Part file: ArrayList<MultipartBody.Part>?): Response<ImageUploadResponse>

}