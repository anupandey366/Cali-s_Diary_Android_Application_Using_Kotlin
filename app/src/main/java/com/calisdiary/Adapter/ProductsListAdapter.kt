package com.example.farmserv

import java.util.ArrayList
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.calisdiary.Interface.ProductViewClick
import com.calisdiary.ModalClass.ProductsListModal
import com.calisdiary.ModalClass.ServicesListModal
import com.calisdiary.R
import com.calisdiary.ui.Activities.ProductActivity
import com.calisdiary.ui.Activities.ServiceActivity


class ProductsListAdapter(val context: Context, val arrProduct: ArrayList<ProductsListModal>, val click: ProductViewClick)
    : RecyclerView.Adapter<ProductsListAdapter.ViewHolder>(){


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val productName = itemView.findViewById<TextView>(R.id.tvProductName)
        val productId = itemView.findViewById<TextView>(R.id.tvProductId)
        val productCategory = itemView.findViewById<TextView>(R.id.tvCategory)
        val productSubCategory = itemView.findViewById<TextView>(R.id.tvSubCategory)
        val productCreatedAt = itemView.findViewById<TextView>(R.id.tvCreatedAt)
        val productStatus = itemView.findViewById<TextView>(R.id.tvStatus)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_layout_products_tab, parent, false))
    }

    override fun getItemCount(): Int {
        return arrProduct.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        arrProduct[position].apply {

            holder.productName.text = productName
            holder.productId.text = productId
            holder.productCategory.text = productCategory
            holder.productSubCategory.text = productSubCategory
            holder.productCreatedAt.text = productCreatedAt
            holder.productStatus.text = productStatus
        }


        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context, ProductActivity::class.java))
//            click.viewProducts("Aditya","View",1000)
        }
    }


}