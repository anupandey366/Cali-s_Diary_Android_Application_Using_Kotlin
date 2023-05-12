package com.calisdiary.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.calisdiary.R

class MyProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my_profile, container, false)

        val llEditProfileButton= view.findViewById<LinearLayout>(R.id.llEditProfileButton)

        llEditProfileButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.vendorContainer,EditProfileFragment())
                .addToBackStack("EditProfileFragment").commit()

        }


        return view
    }

}