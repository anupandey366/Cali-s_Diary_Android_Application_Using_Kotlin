package com.calisdiary.ui.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.calisdiary.Adapter.ApprovedProductRecyclerAdapter
import com.calisdiary.Interface.ProductViewClick
import com.calisdiary.ModalClass.ApprovedProductModalClass
import com.calisdiary.R
import com.calisdiary.databinding.ActivityApprovedProductBinding

class ApprovedProductActivity : AppCompatActivity(), ProductViewClick {

    lateinit var binding: ActivityApprovedProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApprovedProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ApprovedProductDetails = ArrayList<ApprovedProductModalClass>()

        ApprovedProductDetails.add(ApprovedProductModalClass(R.drawable.dog,"Good Pet Service","S00047","May 06 2023 03:09 PM"))
        ApprovedProductDetails.add(ApprovedProductModalClass(R.drawable.dog,"Good Pet Service","S00047","May 06 2023 03:09 PM"))
        ApprovedProductDetails.add(ApprovedProductModalClass(R.drawable.dog,"Good Pet Service","S00047","May 06 2023 03:09 PM"))
        ApprovedProductDetails.add(ApprovedProductModalClass(R.drawable.dog,"Good Pet Service","S00047","May 06 2023 03:09 PM"))
        ApprovedProductDetails.add(ApprovedProductModalClass(R.drawable.dog,"Good Pet Service","S00047","May 06 2023 03:09 PM"))

        binding.rvInterestedRecycler.layoutManager = LinearLayoutManager(this)
        val recyclerApprovedProductAdapter = ApprovedProductRecyclerAdapter(this,ApprovedProductDetails,this)
        binding.rvInterestedRecycler.adapter = recyclerApprovedProductAdapter

    }

    override fun viewProducts(name: String, type: String, price: Int) {

    }
}