package com.calisdiary.ui.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.calisdiary.R
import com.calisdiary.databinding.ActivityOtpverificationBinding

class OTPVerificationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOtpverificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityOtpverificationBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }
}