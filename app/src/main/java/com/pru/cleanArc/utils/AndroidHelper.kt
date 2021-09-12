package com.pru.cleanArc.utils

import android.content.Context
import android.view.Gravity.CENTER
import android.widget.Toast

object AndroidHelper {
    fun Context.showToast(msg: String) {
        val toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT)
        toast.setGravity(CENTER, 0, 0)
        toast.show()
    }
}