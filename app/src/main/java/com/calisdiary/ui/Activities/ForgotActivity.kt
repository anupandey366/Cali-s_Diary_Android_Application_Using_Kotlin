package com.calisdiary.ui.Activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.calisdiary.R
import com.calisdiary.Validations.FormValidations
import com.calisdiary.databinding.ActivityForgotBinding

class ForgotActivity : AppCompatActivity() {

    var flag = ""
    var value = ""
    var phoneOrMail = ""
    var from = ""
    //private val viewModel: ForgotPasswordViewModel by viewModels()

    private lateinit var binding: ActivityForgotBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityForgotBinding.inflate(layoutInflater)
        setContentView(binding.root)



        intent?.getStringExtra("from")?.let { from = it }


        if (flag == "mail"){
            binding.etEmail.addTextChangedListener(textWatcherEmail)
        }else{
            binding.etMobileNumber.addTextChangedListener(textWatcher)
        }

        click()

       // observeForgotPasswordResponse()




    }

    private fun click() {
        binding.emailSelected.setOnClickListener {
            flag = "mail"
            binding.llMobileView.visibility  = View.GONE
            binding.llEmailView.visibility  = View.VISIBLE
            binding.emailSelected.setBackgroundResource(R.drawable.button_background)
            binding.emailTV.setTextColor(Color.parseColor("#FFFFFF"))

            binding.mobileSelected.setBackgroundResource(R.drawable.border_background)
            binding.mobileTV.setTextColor(Color.parseColor("#8BD9C7"))

            binding.etEmail.addTextChangedListener(textWatcherEmail)


        }

        binding.mobileSelected.setOnClickListener {
            flag = "phone"
            binding.llMobileView.visibility  = View.VISIBLE
            binding.llEmailView.visibility  = View.GONE

            binding.mobileSelected.setBackgroundResource(R.drawable.button_background)
            binding.mobileTV.setTextColor(Color.parseColor("#FFFFFF"))

            binding.emailSelected.setBackgroundResource(R.drawable.border_background)
            binding.emailTV.setTextColor(Color.parseColor("#8BD9C7"))

            binding.etMobileNumber.addTextChangedListener(textWatcher)

        }
        binding.SubmitButton.setOnClickListener {
            if(flag  == "mail"){

                FormValidations.forgotPasswordByMail(binding.etEmail,binding.llEmail,binding.tvEmail,this@ForgotActivity)

                val email = binding.etEmail.text.toString()

                if(email.isNotEmpty() && email.matches(Regex(FormValidations.emailPattern))){

                    if (from == "vendor"){
//                        val jsonObject = JsonObject()
//                        jsonObject.addProperty("email", email)
//                        jsonObject.addProperty("userTypes" ,"VENDOR")

                       // viewModel.forgotPasswordApi(jsonObject)
                    }else{
//                        val jsonObject = JsonObject()
//                        jsonObject.addProperty("email", email)
//                        jsonObject.addProperty("userTypes" ,"USER")
//
//                        viewModel.forgotPasswordApi(jsonObject)
                    }

                    value = email
                }
            }else{
                FormValidations.forgotPasswordByPhone(binding.etMobileNumber,binding.llMobileNumber,binding.tvMobile,this@ForgotActivity)

                val Mobile = binding.etMobileNumber.text.toString()

                if(Mobile.isNotEmpty() && Mobile.length > 9){
                    if (from == "vendor"){
//                        val jsonObject = JsonObject()
//                        jsonObject.addProperty("email", Mobile)
//                        jsonObject.addProperty("userTypes" ,"VENDOR")
//
//                        viewModel.forgotPasswordApi(jsonObject)
                    }else{
//                        val jsonObject = JsonObject()
//                        jsonObject.addProperty("email", Mobile)
//                        jsonObject.addProperty("userTypes" ,"USER")
//
//                        viewModel.forgotPasswordApi(jsonObject)
                    }


                    value = Mobile
                }

                val intent=Intent(this,OTPVerificationActivity::class.java)
                startActivity(intent)

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
            FormValidations.forgotPasswordByPhone(binding.etMobileNumber,binding.llMobileNumber,binding.tvMobile,this@ForgotActivity)
        }
    }


    private val textWatcherEmail = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {

        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            FormValidations.forgotPasswordByMail(binding.etEmail,binding.llEmail,binding.tvEmail,this@ForgotActivity)
        }
    }


    //     Forgot password observer



//    private fun observeForgotPasswordResponse() {
//
//
//        lifecycleScope.launchWhenCreated {
//            viewModel._forgotPasswordData.collect { response ->
//
//                when (response) {
//
//                    is Resource.Success -> {
//
//                        Progresss.stop()
//                        if(response.data?.statusCode == 200) {
//                            try {
//
//
//                                phoneOrMail = if (binding.etEmail.text.isEmpty()){
//                                    binding.etMobileNumber.text.toString()
//                                }else{
//                                    binding.etEmail.text.toString()
//                                }
//
//                                val intent = Intent(this@ForgotActivity,OTPVerificationActivity::class.java)
//                                if(flag  == "mail"){
//                                    intent.putExtra("flag","mailText")
//                                }else{
//                                    intent.putExtra("flag","numberText")
//                                }
//
//                                intent.putExtra("_id",response.data.result._id)
//                                intent.putExtra("number",phoneOrMail)
//                                intent.putExtra("email",phoneOrMail)
//                                intent.putExtra("vendor",from)
//                                intent.putExtra("from","Forgot")
//                                startActivity(intent)
//                                finishAfterTransition()
//
//                            }catch (e:Exception){
//                                e.printStackTrace()
//                            }
//                        }
//                    }
//
//                    is Resource.Error -> {
//
//                        Progresss.stop()
//                        response.message?.let { message ->
//                            androidExtension.alertBox(message, this@ForgotActivity)
//                        }
//                    }
//
//                    is Resource.Loading -> {
//                        Progresss.start(this@ForgotActivity)
//                    }
//
//                    is Resource.Empty -> {
//                        Progresss.stop()
//                    }
//
//                }
//
//            }
//        }
//    }






}