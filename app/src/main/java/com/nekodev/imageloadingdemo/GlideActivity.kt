package com.nekodev.imageloadingdemo

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_image.*

class GlideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        titleText.text = "Glide"
        loadButton.setOnClickListener { loadImage() }
    }

    private fun loadImage() {
        Glide.with(this)
                .load(IMAGE_URL)
                .addListener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                        onImageFetchError(e)
                        return false
                    }

                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        onImageFetched()
                        return false
                    }
                })
                .into(imageView)
    }

    private fun onImageFetched() {
        showToast("success")
    }

    private fun onImageFetchError(e: GlideException?) {
        showToast("error ${e?.message}")
    }
}