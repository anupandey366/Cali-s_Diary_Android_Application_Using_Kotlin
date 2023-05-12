package com.calisdiary.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.calisdiary.Adapter.HomeDashboardRecyclerAdapter
import com.calisdiary.Interface.ProductViewClick
import com.calisdiary.ModalClass.HomeDashboardModalClass
import com.calisdiary.R

class HomeTabFragment : Fragment(), ProductViewClick {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_home_tab, container, false)


        val DashboardRecycler = view.findViewById<RecyclerView>(R.id.DashboardRecycler)

        val DashboardDetails = ArrayList<HomeDashboardModalClass>()

        DashboardDetails.add(HomeDashboardModalClass("30",R.drawable.product,"Total Products"))
        DashboardDetails.add(HomeDashboardModalClass("24",R.drawable.product,"Approved Products"))
        DashboardDetails.add(HomeDashboardModalClass("9",R.drawable.product,"Pending Products"))
        DashboardDetails.add(HomeDashboardModalClass("0",R.drawable.product,"Rejected Products"))
        DashboardDetails.add(HomeDashboardModalClass("27",R.drawable.service_vendor,"Total Services"))
        DashboardDetails.add(HomeDashboardModalClass("5",R.drawable.service_vendor,"Pending Services"))
        DashboardDetails.add(HomeDashboardModalClass("0",R.drawable.service_vendor,"Rejected Services"))
        DashboardDetails.add(HomeDashboardModalClass("22",R.drawable.service_vendor,"Approved Services"))
        DashboardDetails.add(HomeDashboardModalClass("80",R.drawable.product,"Client Interested in Products"))
        DashboardDetails.add(HomeDashboardModalClass("50",R.drawable.pet_tab,"Client Interested in  Pets"))
        DashboardDetails.add(HomeDashboardModalClass("65",R.drawable.service_vendor,"Client Interested in  Services"))

        DashboardRecycler.layoutManager = GridLayoutManager(view.context,2)
        val recyclerDashboardAdapter = HomeDashboardRecyclerAdapter(view.context,DashboardDetails,this)
        DashboardRecycler.adapter = recyclerDashboardAdapter

        return view
    }

    override fun viewProducts(name: String, type: String, price: Int) {

    }

}