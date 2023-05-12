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
import com.calisdiary.ModalClass.PetsListModal
import com.calisdiary.R
import com.calisdiary.ui.Activities.PetActivity
import com.calisdiary.ui.Activities.ServiceActivity


class PetsListAdapter(val context: Context, val arrProduct: ArrayList<PetsListModal>, val click: ProductViewClick)
    : RecyclerView.Adapter<PetsListAdapter.ViewHolder>(){


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvPetName = itemView.findViewById<TextView>(R.id.tvPetName)
        val tvPetBreed = itemView.findViewById<TextView>(R.id.tvPetBreed)
        val tvPurchasedStore = itemView.findViewById<TextView>(R.id.tvPurchasedStore)
        val tvLanguage = itemView.findViewById<TextView>(R.id.tvLanguage)
        val tvDOB = itemView.findViewById<TextView>(R.id.tvDOB)
        val tvCreatedAt = itemView.findViewById<TextView>(R.id.tvCreatedAt)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_layout_pets_tab, parent, false))
    }

    override fun getItemCount(): Int {
        return arrProduct.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        arrProduct[position].apply {

            holder.tvPetName.text = petName
            holder.tvPetBreed.text = petBreed
            holder.tvPurchasedStore.text = purchasedStore
            holder.tvLanguage.text = language
            holder.tvDOB.text = DOB
            holder.tvCreatedAt.text = createdAt
        }


        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context, PetActivity::class.java))
//            click.viewProducts("Aditya","View",1000)
        }
    }


}