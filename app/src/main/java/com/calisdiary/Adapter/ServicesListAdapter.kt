package com.calisdiary.Adapter

import java.util.ArrayList
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.calisdiary.Interface.ProductViewClick
import com.calisdiary.ModalClass.ServicesListModal
import com.calisdiary.R
import com.calisdiary.ui.Activities.ServiceActivity


class ServicesListAdapter(val context: Context, val arrProduct: ArrayList<ServicesListModal>,val click: ProductViewClick)
    : RecyclerView.Adapter<ServicesListAdapter.ViewHolder>(){


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvId = itemView.findViewById<TextView>(R.id.tvId)
        val tvCategory = itemView.findViewById<TextView>(R.id.tvCategory)
        val tvSubCategory = itemView.findViewById<TextView>(R.id.tvSubCategory)
        val tvCreatedAt = itemView.findViewById<TextView>(R.id.tvCreatedAt)
        val tvStatus = itemView.findViewById<TextView>(R.id.tvStatus)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_layout_services_tab, parent, false))
    }

    override fun getItemCount(): Int {
        return arrProduct.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        arrProduct[position].apply {

            holder.tvName.text = name
            holder.tvId.text = id
            holder.tvCategory.text = category
            holder.tvSubCategory.text = subCategory
            holder.tvCreatedAt.text = createdAt
            holder.tvStatus.text = status
        }


        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context, ServiceActivity::class.java))
//            click.viewProducts("Aditya","View",1000)
        }
    }


}