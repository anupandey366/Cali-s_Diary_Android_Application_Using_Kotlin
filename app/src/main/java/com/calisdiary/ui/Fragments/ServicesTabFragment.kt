package com.calisdiary.ui.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.calisdiary.Adapter.ServicesListAdapter
import com.calisdiary.Interface.ProductViewClick
import com.calisdiary.ModalClass.ServicesListModal
import com.calisdiary.R

class ServicesTabFragment : Fragment() , ProductViewClick {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_services_tab, container, false)

        var serviceListRecycler= view.findViewById<RecyclerView>(R.id.serviceListRecycler)

        val serviceListArr = ArrayList<ServicesListModal>()
        serviceListArr.add(ServicesListModal("Testing Service","S00050","Dog Training",
            "Advance Training","Apr 26 2023 08:02 PM","PENDING"))
        serviceListArr.add(ServicesListModal("Good Pet Service","S00049","Grooming",
            "Hand Grooming","Apr 24 2023 06:32 PM","APPROVED"))
        serviceListArr.add(ServicesListModal("Pet Dry Service","S00048","Grooming",
            "Hand Grooming","Jan 18 2023 05:52 PM","APPROVED"))
        serviceListArr.add(ServicesListModal("Testing Service","S00050","Dog Training",
            "Advance Training","Apr 26 2023 08:02 PM","PENDING"))
        serviceListArr.add(ServicesListModal("Good Pet Service","S00049","Grooming",
            "Hand Grooming","Apr 24 2023 06:32 PM","APPROVED"))
        serviceListArr.add(ServicesListModal("Pet Dry Service","S00048","Grooming",
            "Hand Grooming","Jan 18 2023 05:52 PM","APPROVED"))


        serviceListRecycler.adapter = ServicesListAdapter(view.context,serviceListArr,this)
        serviceListRecycler.layoutManager = LinearLayoutManager(view.context)

        return view
    }

    override fun viewProducts(name: String, type: String, price: Int) {

    }

}