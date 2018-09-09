package com.nekodev.imageloadingdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.squareup.picasso.clearCache
import kotlinx.android.synthetic.main.activity_image.*

class PicassoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        titleText.text = "Picasso"
        loadButton.setOnClickListener { loadImage() }
    }

    private fun loadImage() {
        progressBar.visibility = View.VISIBLE
        Picasso.get().clearCache(IMAGE_URL)
        Picasso.get()
                .load(IMAGE_URL)
                .into(imageView, object : Callback {
                    override fun onError(e: Exception) {
                        onImageFetchError(e)
                    }
                    override fun onSuccess() {
                        onImageFetched()
                    }
                })
    }

    private fun onImageFetched() {
        showToast("success")
        progressBar.visibility = View.GONE
    }

    private fun onImageFetchError(e: Exception) {
        showToast("error")
        progressBar.visibility = View.GONE
    }
}