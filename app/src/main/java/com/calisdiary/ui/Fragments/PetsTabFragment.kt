package com.calisdiary.ui.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.calisdiary.Adapter.PetsListAdapter
import com.calisdiary.Interface.ProductViewClick
import com.calisdiary.ModalClass.PetsListModal
import com.calisdiary.R

class PetsTabFragment : Fragment()  , ProductViewClick {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_pets_tab, container, false)

        var petsListRecycler= view.findViewById<RecyclerView>(R.id.petsListRecycler)

        val petsListArr = ArrayList<PetsListModal>()
        petsListArr.add(
            PetsListModal("Two_Dogs","Unique Breed","ABCD Store",
            "English","17 Jan 2013","Apr 24 2023 06:32 PM")
        )
        petsListArr.add(
            PetsListModal("White Dog","Pet Bull","Good Store",
            "French","15 Mar 2022","Apr 24 2023 06:32 PM")
        )
        petsListArr.add(
            PetsListModal("Pet Dry Service","German Breed","Grooming",
            "Hand Grooming","06 Apr 2016","Jan 18 2023 05:52 PM")
        )
        petsListArr.add(
            PetsListModal("Two_Dogs","12 Unique Dog Breed","ABCD Store",
                "English","17 Jan 2013","Apr 24 2023 06:32 PM")
        )
        petsListArr.add(
            PetsListModal("White Dog","Pet Bull","Good Store",
                "French","15 Mar 2022","Apr 24 2023 06:32 PM")
        )
        petsListArr.add(
            PetsListModal("Pet Dry Service","German Breed","Grooming",
                "Hand Grooming","06 Apr 2016","Jan 18 2023 05:52 PM")
        )


        petsListRecycler.adapter = PetsListAdapter(view.context,petsListArr,this)
        petsListRecycler.layoutManager = LinearLayoutManager(view.context)
        
        return view
    }

    override fun viewProducts(name: String, type: String, price: Int) {
        
    }

}