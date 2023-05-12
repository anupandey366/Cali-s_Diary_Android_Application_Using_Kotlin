package com.calisdiary.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.calisdiary.Interface.ProductViewClick
import com.calisdiary.ModalClass.ApprovedProductModalClass
import com.calisdiary.ModalClass.HomeDashboardModalClass
import com.calisdiary.R
import com.calisdiary.ui.Activities.ApprovedProductActivity
import com.calisdiary.ui.Activities.ProductActivity

class ApprovedProductRecyclerAdapter(val context: Context, val arrApprovedProductDetails: ArrayList<ApprovedProductModalClass>, val clicks:ProductViewClick) : RecyclerView.Adapter<ApprovedProductRecyclerAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val ProductImage = itemView.findViewById<ImageView>(R.id.ivProductImage)
        val ProductName = itemView.findViewById<TextView>(R.id.tvProductName)
        val ProductId = itemView.findViewById<TextView>(R.id.tvProductId)
        val ProductDate = itemView.findViewById<TextView>(R.id.tvProductDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.recycler_layout_approved_product, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return arrApprovedProductDetails.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.ProductImage.setImageResource(arrApprovedProductDetails[position].ProductImage)
        holder.ProductName.text = arrApprovedProductDetails[position].ProductName
        holder.ProductId.text = arrApprovedProductDetails[position].ProductId
        holder.ProductDate.text = arrApprovedProductDetails[position].ProductDate

        holder.itemView.setOnClickListener {
   //         context.startActivity(Intent(context, ApprovedProductActivity::class.java))
//            click.viewProducts("Aditya","View",1000)
        }

    }
}