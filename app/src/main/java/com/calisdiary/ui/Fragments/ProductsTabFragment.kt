package com.calisdiary.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.calisdiary.Interface.ProductViewClick
import com.calisdiary.ModalClass.ProductsListModal
import com.calisdiary.R
import com.example.farmserv.ProductsListAdapter

class ProductsTabFragment : Fragment(), ProductViewClick {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_products_tab, container, false)

        var productListRecycler= view.findViewById<RecyclerView>(R.id.productListRecycler)

        val productListArr = ArrayList<ProductsListModal>()

        productListArr.add(ProductsListModal("Cat_Food","P00071","Food",
            "Non Veg","Apr 26 2023 08:02 PM","APPROVED"))

        productListArr.add(ProductsListModal("Testing Product","P00070","Food",
            "Dog Food","Apr 26 2023 08:02 PM","APPROVED"))

        productListArr.add(ProductsListModal("Wood Food","P00069","Food",
            "Dog Food","Apr 26 2023 08:02 PM","PENDING"))
        productListArr.add(ProductsListModal("Cat_Food","P00071","Food",
            "Non Veg","Apr 26 2023 08:02 PM","APPROVED"))

        productListArr.add(ProductsListModal("Testing Product","P00070","Food",
            "Dog Food","Apr 26 2023 08:02 PM","APPROVED"))

        productListArr.add(ProductsListModal("Wood Food","P00069","Food",
            "Dog Food","Apr 26 2023 08:02 PM","PENDING"))


        productListRecycler.adapter = ProductsListAdapter(view.context,productListArr,this)
        productListRecycler.layoutManager = LinearLayoutManager(view.context)

        return view
    }

    override fun viewProducts(name: String, type: String, price: Int) {

    }


}