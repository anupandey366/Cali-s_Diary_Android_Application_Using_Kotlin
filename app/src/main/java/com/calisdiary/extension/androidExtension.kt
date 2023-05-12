package com.calisdiary.extension

import android.app.AlertDialog
import android.content.Context
import com.calisdiary.R

object androidExtension {


    fun alertBox(message: String, context: Context) {
        var alertDialog: AlertDialog? = null
        val builder = AlertDialog.Builder(context)
        builder.setIcon(R.mipmap.ic_launcher)
        builder.setTitle("Cali's Dairy")
        builder.setMessage(message)

        builder.setPositiveButton("ok") { dialogInterface, which ->
            alertDialog!!.dismiss()
        }
        alertDialog = builder.create()
        alertDialog!!.setCancelable(false)
        alertDialog!!.show()
    }


}