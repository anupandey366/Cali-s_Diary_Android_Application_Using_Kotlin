package com.calisdiary.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.calisdiary.Interface.PopupItemClickListener
import com.calisdiary.R
import com.calisdiary.api.response.CountryList

class openDialog (
    var context: Context,
    var data: ArrayList<CountryList>,
    var flag: String,
    var click: PopupItemClickListener
) :
    RecyclerView.Adapter<openDialog.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val mInflater = LayoutInflater.from(context)
        val view = mInflater.inflate(R.layout.lists, parent, false)

        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Data = data[position]

        if (flag == "State" ){
            holder.Names.text = Data.name
            holder.Names.setOnClickListener {
                Data.name.let { it1 -> click.getData(it1,flag,Data.isoCode) }
            }

        }else if (flag == "City"){
            holder.Names.text = Data.name
            holder.Names.setOnClickListener {
                Data.name.let { it1 -> click.getData(it1,flag,Data.isoCode) }
            }

        }else if (flag == "Country"){
            holder.Names.text = Data.name
            holder.Names.setOnClickListener {
                Data.name.let { it1 -> click.getData(it1,flag,Data.isoCode) }
            }

        } else if (flag == "Region") {
            holder.Names.text = Data.name
            holder.Names.setOnClickListener {
                Data.name.let { it1 -> click.getData(it1,flag,"") }
            }

        } else if (flag == "Pet Type") {
            holder.Names.text = Data.petCategoryName
            holder.Names.setOnClickListener {
                Data.petCategoryName.let { it1 -> click.getData(it1,flag,Data._id) }
            }

        }else {

        }



    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        var Names: TextView



        init {
            Names = itemView.findViewById(R.id.content_textView)

        }
    }


    @SuppressLint("NotifyDataSetChanged")
    fun filterList(filteredList: ArrayList<CountryList>) {
        data = filteredList
        notifyDataSetChanged()

    }


}