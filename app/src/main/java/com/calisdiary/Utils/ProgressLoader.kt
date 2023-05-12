package com.calisdiary.Utils

import android.app.ProgressDialog
import android.content.Context
import android.view.WindowManager
import com.calisdiary.R

object Progresss {
    var dialog: ProgressDialog? = null

    fun start(context: Context?) {
        dialog = ProgressDialog(context)
        try {
            dialog!!.show()
        } catch (_: WindowManager.BadTokenException) {
        }
        dialog!!.setCancelable(false)
        dialog!!.setContentView(R.layout.loader)
        dialog!!.window?.setBackgroundDrawableResource(android.R.color.transparent)

    }

    fun stop() {
        if (dialog != null){
            dialog!!.dismiss()
        }

    }
}