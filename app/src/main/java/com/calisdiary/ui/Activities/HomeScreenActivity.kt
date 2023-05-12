package com.calisdiary.ui.Activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.calisdiary.Interface.AddListenerVendor
import com.calisdiary.R
import com.calisdiary.databinding.ActivityHomeScreenBinding
import com.calisdiary.ui.Fragments.*

class HomeScreenActivity : AppCompatActivity(), View.OnClickListener, AddListenerVendor {


    lateinit var HomeBottomTab: RelativeLayout
    lateinit var productTabs: RelativeLayout
    lateinit var petsTab: RelativeLayout
    lateinit var serviceTab: RelativeLayout
    lateinit var settingsTab: RelativeLayout
    /*private var mLastClickTime: Long = 0
    lateinit var socketInstance: SocketManager*/


    lateinit var homeTv: TextView
    lateinit var productTv: TextView
    lateinit var petTv: TextView
    lateinit var serviceTv: TextView
    lateinit var settingsTv: TextView


    lateinit var settingsView:View
    lateinit var serviceView:View
    lateinit var petsView:View
    lateinit var productView:View
    lateinit var Homeview:View


    lateinit var binding : ActivityHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        HomeBottomTab = findViewById(R.id.HomeBottomTab)
        productTabs = findViewById(R.id.productTabs)
        petsTab = findViewById(R.id.petsTab)
        serviceTab = findViewById(R.id.serviceTab)
        settingsTab = findViewById(R.id.settingsTab)

        homeTv = findViewById(R.id.homeTv)
        productTv = findViewById(R.id.productTv)
        petTv = findViewById(R.id.petTv)
        serviceTv = findViewById(R.id.serviceTv)
        settingsTv = findViewById(R.id.settingsTv)

        settingsView = findViewById(R.id.settingsView)
        serviceView = findViewById(R.id.serviceView)
        petsView = findViewById(R.id.petsView)
        productView = findViewById(R.id.productView)
        Homeview = findViewById(R.id.Homeview)

        supportFragmentManager.beginTransaction().replace(R.id.vendorContainer, HomeTabFragment()).commit()
        HomeBottomTab.isEnabled = false

        /*val homeTabFragment = HomeTabFragment()
        val productsTabFragment = ProductsTabFragment()
        val servicesTabFragment = ServicesTabFragment()
        val petsTabFragment = PetsTabFragment()
        val menuTabFragment = MenuTabFragment()*/








        clicks()
    }
    private fun clicks() {
        HomeBottomTab.setOnClickListener(this)
        productTabs.setOnClickListener(this)
        petsTab.setOnClickListener(this)
        serviceTab.setOnClickListener(this)
        settingsTab.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v?.id) {

            R.id.HomeBottomTab -> {
                supportFragmentManager.beginTransaction().replace(R.id.vendorContainer, HomeTabFragment()).commit()
                HomeBottomTab.isEnabled = false

                homeTv.setTextColor(Color.parseColor("#6FCFB9"))
                productTv.setTextColor(Color.parseColor("#757575"))
                petTv.setTextColor(Color.parseColor("#757575"))
                serviceTv.setTextColor(Color.parseColor("#757575"))
                settingsTv.setTextColor(Color.parseColor("#757575"))

                Homeview.isVisible = true
                productView.isVisible = false
                petsView.isVisible = false
                serviceView.isVisible = false
                settingsView.isVisible = false

            }

            R.id.productTabs -> {
                HomeBottomTab.isEnabled = true

                val bundle = Bundle()
                bundle.putString("product","Total Products")
                val obj = ProductsTabFragment()
                obj.arguments = bundle

                supportFragmentManager.beginTransaction().replace(R.id.vendorContainer,obj).addToBackStack("VendorProductFragment").commit()

                homeTv.setTextColor(Color.parseColor("#757575"))
                productTv.setTextColor(Color.parseColor("#6FCFB9"))
                petTv.setTextColor(Color.parseColor("#757575"))
                serviceTv.setTextColor(Color.parseColor("#757575"))
                settingsTv.setTextColor(Color.parseColor("#757575"))

                Homeview.isVisible = false
                productView.isVisible = true
                petsView.isVisible = false
                serviceView.isVisible = false
                settingsView.isVisible = false
            }

            R.id.petsTab -> {
                HomeBottomTab.isEnabled = true
                supportFragmentManager.beginTransaction().replace(R.id.vendorContainer, PetsTabFragment()).addToBackStack("VendorProductFragment").commit()

                homeTv.setTextColor(Color.parseColor("#757575"))
                productTv.setTextColor(Color.parseColor("#757575"))
                petTv.setTextColor(Color.parseColor("#6FCFB9"))
                serviceTv.setTextColor(Color.parseColor("#757575"))
                settingsTv.setTextColor(Color.parseColor("#757575"))

                Homeview.isVisible = false
                productView.isVisible = false
                petsView.isVisible = true
                serviceView.isVisible = false
                settingsView.isVisible = false
            }

            R.id.serviceTab -> {
                HomeBottomTab.isEnabled = true

                val bundle = Bundle()
                bundle.putString("service","Total Services")
                val obj = ServicesTabFragment()
                obj.arguments = bundle

                supportFragmentManager.beginTransaction().replace(R.id.vendorContainer, obj).addToBackStack("VendorProductFragment").commit()

                homeTv.setTextColor(Color.parseColor("#757575"))
                productTv.setTextColor(Color.parseColor("#757575"))
                petTv.setTextColor(Color.parseColor("#757575"))
                serviceTv.setTextColor(Color.parseColor("#6FCFB9"))
                settingsTv.setTextColor(Color.parseColor("#757575"))

                Homeview.isVisible = false
                productView.isVisible = false
                petsView.isVisible = false
                serviceView.isVisible = true
                settingsView.isVisible = false
            }

            R.id.settingsTab -> {
                HomeBottomTab.isEnabled = true


                supportFragmentManager.beginTransaction().replace(R.id.vendorContainer, MenuTabFragment()).addToBackStack("MenuVendorFragment").commit()

                homeTv.setTextColor(Color.parseColor("#757575"))
                productTv.setTextColor(Color.parseColor("#757575"))
                petTv.setTextColor(Color.parseColor("#757575"))
                serviceTv.setTextColor(Color.parseColor("#757575"))
                settingsTv.setTextColor(Color.parseColor("#6FCFB9"))

                Homeview.isVisible = false
                productView.isVisible = false
                petsView.isVisible = false
                serviceView.isVisible = false
                settingsView.isVisible = true
            }

            /*R.id.ChatClick -> {
                val intent = Intent(this, ChatsActivity::class.java)
                startActivity(intent)
            }*/


            /*R.id.addVendors -> {

                supportFragmentManager.let { it1 ->
                    VendorAddPosts(this).show(
                        it1, "Follow Bottom Sheet Dialog Fragment"
                    )
                }
            }*/



        }
    }
    private fun replaceFragment(fragment: Fragment) {
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.vendorContainer,fragment)  //.addToBackStack("n2n")
            transaction.commit()
        }

    }

    override fun pet() {

    }

    override fun product() {

    }

    override fun service() {

    }

}