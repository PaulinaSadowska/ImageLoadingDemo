package com.nekodev.imageloadingdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        picassoText.setOnClickListener { startActivity(PicassoActivity::class) }
        glideText.setOnClickListener { startActivity(GlideActivity::class) }
        imageLoaderText.setOnClickListener { startActivity(ImageLoaderActivity::class) }

    }
}
