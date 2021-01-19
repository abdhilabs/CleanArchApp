package com.abdhilabs.learncleanarch.helper.extension

import android.content.Context
import android.os.Build
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.abdhilabs.learncleanarch.R
import com.google.android.material.snackbar.Snackbar

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun Context?.toast(msg: String) =
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

@RequiresApi(Build.VERSION_CODES.M)
fun View.snackBarCaution(msg: String?) =
    Snackbar.make(this, msg.toString(), Snackbar.LENGTH_SHORT).apply {
        view.setBackgroundColor(resources.getColor(R.color.colorRed, null))
        show()
    }

fun View.snackBarError(msg: String?) =
    Snackbar.make(this, msg.toString(), Snackbar.LENGTH_LONG).show()

fun EditText.isNull() =
    text.isNullOrEmpty()

fun EditText.msgError(value: String) {
    if (text.isNullOrEmpty()) error = "${value}nya diisi dulu ya kak."
}