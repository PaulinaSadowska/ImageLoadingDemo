package com.nekodev.imageloadingdemo

import android.graphics.Bitmap
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.nostra13.universalimageloader.core.DisplayImageOptions
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.assist.FailReason
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener
import kotlinx.android.synthetic.main.activity_image.*


class ImageLoaderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        titleText.text = "Universal Image Loader"
        ImageLoader.getInstance().setDefaultLoadingListener(object : ImageLoadingListener {
            override fun onLoadingComplete(imageUri: String?, view: View?, loadedImage: Bitmap?) {
                showToast("success")
            }

            override fun onLoadingStarted(imageUri: String?, view: View?) {
                showToast("started")
            }

            override fun onLoadingCancelled(imageUri: String?, view: View?) {
                showToast("cancelled")
            }

            override fun onLoadingFailed(imageUri: String?, view: View?, failReason: FailReason?) {
                showToast("error")
            }

        })

        loadButton.setOnClickListener { loadImage() }
    }

    private fun loadImage() {
        val options = DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build()
        ImageLoader.getInstance()
                .displayImage(IMAGE_URL, imageView, options)
    }
}