package com.nekodev.imageloadingdemo

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlin.reflect.KClass

fun Context.startActivity(cls: KClass<out AppCompatActivity>) {
    startActivity(Intent(this, cls.java))
}

fun Context.showToast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}