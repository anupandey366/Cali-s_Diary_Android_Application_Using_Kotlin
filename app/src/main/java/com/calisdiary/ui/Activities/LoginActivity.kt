package com.calisdiary.ui.Activities

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.Html
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import com.calisdiary.R
import com.calisdiary.Validations.FormValidations
import com.calisdiary.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private var passwordNotVisible = 0
    var flag  = "phone"
    var email = ""
    var Mobile = ""
    var FCMtoken = ""


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)




        val text = this.resources.getString(R.string.don_t_have_a_account_signup)
        val secondName = "<font color=\"#6FCFB9\">${getString(R.string.sign_up)}</font>"
        binding.havingNoAccount.text = Html.fromHtml("$text $secondName", HtmlCompat.FROM_HTML_MODE_LEGACY)
        binding.havingNoAccount.setOnClickListener {
            val intent=Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }


//        RequestPermission.requestMultiplePermissions(this)


//        binding.LoginButton.setOnClickListener {
//            val intent=Intent(this,HomeScreenActivity::class.java)
//            startActivity(intent)
//        }

        binding.forgotPassword.setOnClickListener {
            val intent=Intent(this,ForgotActivity::class.java)
            startActivity(intent)
        }



        if (flag == "mail"){
            binding.etEmail.addTextChangedListener(textWatcherEmail)
            binding.etEmailPassword.addTextChangedListener(textWatcherEmail)
        }else{
            binding.etMobileNumber.addTextChangedListener(textWatcher)
            binding.etPassword.addTextChangedListener(textWatcher)
        }


        click()

        getFCMToken()
      //  observeLoginResponse()
    }

//    private fun observeLoginResponse() {
//
//        lifecycleScope.launch {
//            viewModel._loginData.collect { response ->
//
//                when (response) {
//                    is Resource.Success<*> -> {
//                        Progresss.stop()
//                        if(response.data!!.responseCode == 200) {
//                            try{
//                                SavedPrefManager.saveStringPreferences(this@LoginActivity,SavedPrefManager.Token,response.data.result.token)
//                                SavedPrefManager.saveStringPreferences(this@LoginActivity,SavedPrefManager.userId,response.data.result._id)
//                                SavedPrefManager.savePreferenceBoolean(this@LoginActivity, SavedPrefManager.isVendor,true)
//                                SavedPrefManager.savePreferenceBoolean(this@LoginActivity, SavedPrefManager.isUser,false)
//                                SavedPrefManager.saveStringPreferences(this@LoginActivity, SavedPrefManager.DeviceToken,FCMtoken)
//                                val intent = Intent(this@LoginActivity, HomeScreenActivity::class.java)
//                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//                                startActivity(intent)
//
//                            }catch (e:Exception){
//                                e.printStackTrace()
//                            }
//                        }
//                    }
//
//                    is Resource.Error<*> -> {
//                        Progresss.stop()
//                        response.message?.let { message ->
//                            androidExtension.alertBox(message, this@LoginActivity)
//                        }
//                    }
//
//                    is Resource.Loading<*> -> {
//                        Progresss.start(this@LoginActivity)
//                    }
//
//                    is Resource.Empty<*> -> {
//                        Progresss.stop()
//                    }
//
//                }
//
//            }
//        }
//    }







    private fun getFCMToken() {



//        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
//            if (!task.isSuccessful) {
//
//                return@OnCompleteListener
//            }
//            FCMtoken = task.result
//
//
//            println("Token>>>>>>>>>>>>>>> $FCMtoken")
//
//        })





    }

    private fun click() {

        binding.emailSelected.setOnClickListener {
            flag  =  "mail"
            binding.llMobileView.visibility  = View.GONE
            binding.llEmailView.visibility  = View.VISIBLE
            binding.emailSelected.setBackgroundResource(R.drawable.button_background)
            binding.emailTV.setTextColor(Color.parseColor("#FFFFFF"))

            binding.mobileSelected.setBackgroundResource(R.drawable.border_background)
            binding.mobileTV.setTextColor(Color.parseColor("#8BD9C7"))

            binding.etEmail.addTextChangedListener(textWatcherEmail)
            binding.etEmailPassword.addTextChangedListener(textWatcherEmail)
        }
        binding.mobileSelected.setOnClickListener {
            flag  =  "phone"

            binding.llMobileView.visibility  = View.VISIBLE
            binding.llEmailView.visibility  = View.GONE

            binding.mobileSelected.setBackgroundResource(R.drawable.button_background)
            binding.mobileTV.setTextColor(Color.parseColor("#FFFFFF"))

            binding.emailSelected.setBackgroundResource(R.drawable.border_background)
            binding.emailTV.setTextColor(Color.parseColor("#8BD9C7"))


        }
        binding.MobilePasswordEye.setOnClickListener {
            binding.etPassword.setSelection(binding.etPassword.text.length)
            when (passwordNotVisible) {
                0 -> {
                    binding.etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                    binding.passwordImage.setImageDrawable(resources.getDrawable(R.drawable.eye))
                    passwordNotVisible = 1


                }
                1 -> {
                    binding.etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                    binding.passwordImage.setImageDrawable(resources.getDrawable(R.drawable.password_view))
                    passwordNotVisible = 0
                }
                else -> {
                    binding.etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                    binding.passwordImage.setImageDrawable(resources.getDrawable(R.drawable.eye))
                    passwordNotVisible = 1
                }
            }
        }

        binding.EmailPasswordEye.setOnClickListener {
            binding.etEmailPassword.setSelection(binding.etEmailPassword.text.length)

            when (passwordNotVisible) {
                0 -> {
                    binding.etEmailPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                    binding.EmailPasswordImage.setImageDrawable(resources.getDrawable(R.drawable.eye))
                    passwordNotVisible = 1


                }
                1 -> {
                    binding.etEmailPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                    binding.EmailPasswordImage.setImageDrawable(resources.getDrawable(R.drawable.password_view))
                    passwordNotVisible = 0
                }
                else -> {
                    binding.etEmailPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                    binding.EmailPasswordImage.setImageDrawable(resources.getDrawable(R.drawable.eye))
                    passwordNotVisible = 1
                }
            }
        }


        binding.LoginButton.setOnClickListener {

            if(flag  == "mail"){

                FormValidations.loginByMail(binding.etEmail,binding.tvEmail,binding.llEmailNumber,binding.etEmailPassword,
                    binding.tvEmailPassword,binding.llEmailPassWord, this)

                email = binding.etEmail.text.toString()
                val Pass = binding.etEmailPassword.text.toString()

                if(email.isNotEmpty() && email.matches(Regex(FormValidations.emailPattern)) && Pass.isNotEmpty() && Pass.length > 5){
//
//                    val request = LoginRequest()
//
//                    request.email =  email
//                    request.password =  Pass
//                    request.userTypes = "VENDOR"
//                    request.deviceToken = FCMtoken
//                    request.deviceType = "Android"
//                    request.languageId = SavedPrefManager.getStringPreferences(this,
//                        SavedPrefManager.Language).toString()
//                    viewModel.loginApi(request)

                }
            }else{
                FormValidations.loginByPhone(binding.etMobileNumber,binding.tvMobile,binding.llMobileNumber,binding.etPassword,
                    binding.tvPassword,binding.llPassWord, this)

                Mobile = binding.etMobileNumber.text.toString()
                val Pass = binding.etPassword.text.toString()

                if(Mobile.isNotEmpty() && Mobile.length > 9 && Pass.isNotEmpty() && Pass.length > 5){

//                    val request = LoginRequest()
//
//
//                    request.email =  Mobile
//                    request.password =  Pass
//                    request.userTypes = "VENDOR"
//                    request.deviceToken = FCMtoken
//                    request.deviceType = "Android"
//                    request.languageId = SavedPrefManager.getStringPreferences(this,
//                        SavedPrefManager.Language).toString()
//
//                    viewModel.loginApi(request)
                }
            }



        }




    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            if (s != null) {
                if (s.length == 1 && s.toString().startsWith("0")) {
                    s.clear();
                }
            }
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            FormValidations.loginByPhone(binding.etMobileNumber,binding.tvMobile,binding.llMobileNumber,binding.etPassword, binding.tvPassword,binding.llPassWord, this@LoginActivity)
        }
    }

    private val textWatcherEmail = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {

        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            FormValidations.loginByMail(binding.etEmail,binding.tvEmail,binding.llEmailNumber,binding.etEmailPassword, binding.tvEmailPassword,binding.llEmailPassWord, this@LoginActivity)
        }
    }





}