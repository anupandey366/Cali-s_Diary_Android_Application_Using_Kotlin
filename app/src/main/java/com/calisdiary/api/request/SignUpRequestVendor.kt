package com.calisdiary.api.request

import com.google.gson.annotations.SerializedName


class SignUpRequestVendor {
    @SerializedName("name")
    var name: String = ""
    @SerializedName("countryCode")
    var countryCode: String = ""
    @SerializedName("mobileNumber")
    var mobileNumber: String = ""
    @SerializedName("email")
    var email: String = ""
    @SerializedName("address")
    var address: String = ""
    @SerializedName("city")
    var city: String = ""
    @SerializedName("state")
    var state: String = ""
    @SerializedName("country")
    var country: String = ""
    @SerializedName("password")
    var password: String = ""
    @SerializedName("userTypes")
    var userTypes: String = ""
    @SerializedName("userName")
    var userName: String = ""
    @SerializedName("gender")
    var gender: String = ""
    @SerializedName("zipCode")
    var zipCode: String = ""
    @SerializedName("profilePic")
    var profilePic: String = ""
    @SerializedName("countryIsoCode")
    var countryIsoCode: String = ""
    @SerializedName("stateIsoCode")
    var stateIsoCode: String = ""

    // @SerializedName("documents") var  documents:documents = documents()
    @SerializedName("languageId")
    var languageId: String = ""
}

    class LoginRequest{
        @SerializedName("email") var email:String = ""
        @SerializedName("password") var password:String = ""
        @SerializedName("userTypes") var userTypes:String = ""
        @SerializedName("deviceToken") var deviceToken:String = ""
        @SerializedName("deviceType") var deviceType:String = ""
        @SerializedName("languageId") var languageId:String = ""
    }
