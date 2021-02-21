package com.example.resumeforitpro.utils

import android.content.Context
import android.view.View
import android.widget.Toast

/**
 * Show toast message given message
 * */
fun Context.toast(message: Int) = Toast.makeText(this, message, Toast.LENGTH_LONG).show()

/**
 * Show Loading view
 * */
fun View.showLoading() {
    visibility = View.VISIBLE
}

/**
 * Hide loading
 * */
fun View.hideLoading() {
    visibility = View.GONE
}