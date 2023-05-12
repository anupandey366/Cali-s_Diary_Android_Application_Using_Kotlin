package com.calisdiary.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.calisdiary.R


class MenuTabFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_menu_tab, container, false)

        val llMyProfile= view.findViewById<LinearLayout>(R.id.llMyProfile)

        llMyProfile.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.vendorContainer,MyProfileFragment())
                .addToBackStack("MyProfileFragment").commit()

        }



        return view
    }


}