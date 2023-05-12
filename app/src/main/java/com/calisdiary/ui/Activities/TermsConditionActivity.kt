package com.calisdiary.ui.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.calisdiary.R
import com.calisdiary.databinding.ActivityTermsConditionBinding

class TermsConditionActivity : AppCompatActivity() {

    private lateinit var binding:ActivityTermsConditionBinding

    var flag = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityTermsConditionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.getStringExtra("flag")?.let {
            flag = it
        }

        binding.BackClick.setOnClickListener {
            finishAfterTransition()
        }

        when (flag) {
            "about" -> {
                binding.Title.setText(R.string.about)
                //viewModel.staticApi("aboutUs")
            }
            "terms" -> {
                binding.Title.setText(R.string.terms_conditions)
                //viewModel.staticApi("termsConditions")

            }
            "privacy" -> {
                binding.Title.setText(R.string.privacy_policy)
               // viewModel.staticApi("privacyPolicy")

            }
        }


    }
}