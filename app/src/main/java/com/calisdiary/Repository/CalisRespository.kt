package com.calisdiary.Repository




import com.calisdiary.api.request.LoginRequest
import com.calisdiary.api.request.SignUpRequestVendor
import com.calisdiary.api.response.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.MultipartBody
import retrofit2.Response
import javax.inject.Inject


class CalisRespository @Inject constructor(private val apiServiceImpl: Interface_Implement) {

    fun signInApiVendor(request: SignUpRequestVendor): Flow<Response<SignUpResponse>> = flow {
        emit(apiServiceImpl.signInApiVendor(request))
    }.flowOn(Dispatchers.IO)

    fun getAllCountryApi(): Flow<Response<CountryResponse>> = flow {
        emit(apiServiceImpl.getAllCountryApi("",""))
    }.flowOn(Dispatchers.IO)
//
    fun getAllStateApi(countryCode: String): Flow<Response<CountryResponse>> = flow {
        emit(apiServiceImpl.getAllStateApi(countryCode))
    }.flowOn(Dispatchers.IO)

//

//
    fun login(request: LoginRequest): Flow<Response<LogInResponse>> = flow {
        emit(apiServiceImpl.login(request))
    }.flowOn(Dispatchers.IO)


    fun getAllCityApi(countryCode: String, stateCode: String): Flow<Response<CountryResponse>> =
        flow {
            emit(apiServiceImpl.getAllCityApi(countryCode, stateCode))
        }.flowOn(Dispatchers.IO)


//    fun verifyOTPApi(jsonObject: JsonObject): Flow<Response<VerifyOtpResponse>> = flow {
//        emit(apiServiceImpl.verifyOTPApi(jsonObject))
//    }.flowOn(Dispatchers.IO)
//
//
//    fun resendOTPApi(jsonObject: JsonObject): Flow<Response<VerifyOtpResponse>> = flow {
//        emit(apiServiceImpl.resendOTPApi(jsonObject))
//    }.flowOn(Dispatchers.IO)
//
//
//    fun forgotPasswordApi(jsonObject: JsonObject): Flow<Response<SignUpResponse>> = flow {
//        emit(apiServiceImpl.forgotPasswordApi(jsonObject))
//    }.flowOn(Dispatchers.IO)
//
//
//    fun resetPasswordApi(
//        token: String,
//        password: String,
//        confirmPassword: String
//    ): Flow<Response<SignUpResponse>> = flow {
//        emit(apiServiceImpl.resetPasswordApi(token, password, confirmPassword))
//    }.flowOn(Dispatchers.IO)
//
//
//
//
//
//    fun listCategoryApi(
//        categoryTypes: String,
//        page: Int,
//        limit: Int
//    ): Flow<Response<ListCategoryResponse>> = flow {
//        emit(apiServiceImpl.listCategoryApi(categoryTypes, page, limit))
//    }.flowOn(Dispatchers.IO)
//
//
//
//
//
//    fun changePassword(token: String, jsonObject: JsonObject): Flow<Response<SignUpResponse>> =
//        flow {
//            emit(apiServiceImpl.changePassword(token, jsonObject))
//        }.flowOn(Dispatchers.IO)
//
//
//
//
//
//
//
//
//
//
//
//
//    fun editProfileVendorApi(
//        token: String,
//        request: EditProfileVendorRequest
//    ): Flow<Response<EditProfileResponse>> = flow {
//        emit(apiServiceImpl.editProfileVendorApi(token, request))
//    }.flowOn(Dispatchers.IO)
//
//
//    fun getProfileApi(token: String): Flow<Response<EditProfileResponse>> = flow {
//        emit(apiServiceImpl.getProfileApi(token))
//    }.flowOn(Dispatchers.IO)
//
//
//
//
//
//
//
//    fun updateEventApi(token: String, request: EditEventRequest): Flow<Response<AddEventResponse>> =
//        flow {
//            emit(apiServiceImpl.updateEventApi(token, request))
//        }.flowOn(Dispatchers.IO)
//
//
//
//
//
fun uploadMultipleFile(file: ArrayList<MultipartBody.Part>): Flow<Response<ImageUploadResponse>> =
    flow {
        emit(apiServiceImpl.uploadMultipleFile(file))
    }.flowOn(Dispatchers.IO)






//
//    fun homePagePostListApi(
//        token: String,
//        page: Int,
//        limit: Int,
//        radius: String,
//        country: String,
//        city: String,
//        state: String,
//        lat: Double,
//        long: Double,
//    ): Flow<Response<HomePageListResponse>> = flow {
//        emit(apiServiceImpl.homePagePostListApi(token, page, limit,radius, country, city, state, lat, long))
//    }.flowOn(Dispatchers.IO)
//
//    fun requestListApi(
//        token: String,
//        page: Int,
//        limit: Int
//    ): Flow<Response<RequestedListResponse>> = flow {
//        emit(apiServiceImpl.requestListApi(token, page, limit))
//    }.flowOn(Dispatchers.IO)
//
//    fun userLogout(token: String,fireToken: String): Flow<Response<AddEventResponse>> = flow {
//        emit(apiServiceImpl.userLogout(token,fireToken))}.flowOn(Dispatchers.IO)
//
//
//
//    fun vendorDashboard(token: String): Flow<Response<VendorDashboardResponse>> = flow {
//        emit(apiServiceImpl.vendorDashboard(token))}.flowOn(Dispatchers.IO)




}