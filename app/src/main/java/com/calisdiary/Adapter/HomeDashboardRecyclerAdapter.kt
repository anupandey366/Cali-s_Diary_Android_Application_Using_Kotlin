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
import com.calisdiary.ModalClass.HomeDashboardModalClass
import com.calisdiary.R
import com.calisdiary.ui.Activities.ApprovedProductActivity

class HomeDashboardRecyclerAdapter(val context: Context, val arrDashboardDetails: ArrayList<HomeDashboardModalClass> , val click: ProductViewClick) : RecyclerView.Adapter<HomeDashboardRecyclerAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val number = itemView.findViewById<TextView>(R.id.tv_number)
        val icon = itemView.findViewById<ImageView>(R.id.icons)
        val title = itemView.findViewById<TextView>(R.id.tv_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.recycler_layout_home_tab, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return arrDashboardDetails.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.number.text = arrDashboardDetails[position].number
        holder.icon.setImageResource(arrDashboardDetails[position].icon)
        holder.title.text = arrDashboardDetails[position].title

        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context, ApprovedProductActivity::class.java))
//            click.viewProducts("Aditya","View",1000)
        }

    }
}