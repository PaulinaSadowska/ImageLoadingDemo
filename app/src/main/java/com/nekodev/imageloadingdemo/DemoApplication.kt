package com.nekodev.imageloadingdemo

import android.app.Application
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration
import com.squareup.picasso.Picasso
import java.lang.Exception

class DemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val picassoInstance = Picasso.Builder(applicationContext)
                .listener { _, _, exception -> onImageFetchError(exception) }
                .loggingEnabled(true)
                .build()
        Picasso.setSingletonInstance(picassoInstance)

        val config = ImageLoaderConfiguration.Builder(this)
                .build()
        ImageLoader.getInstance().init(config)
    }

    private fun onImageFetchError(exception: Exception) {
        showToast("fail ${exception.localizedMessage}")
    }
}