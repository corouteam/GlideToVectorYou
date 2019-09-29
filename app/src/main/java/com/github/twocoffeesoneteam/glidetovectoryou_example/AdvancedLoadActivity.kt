package com.github.twocoffeesoneteam.glidetovectoryou_example

import android.graphics.drawable.PictureDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import kotlinx.android.synthetic.main.activity_load.*

class AdvancedLoadActivity : AppCompatActivity() {

    private val IMAGE_URL = "https://upload.wikimedia.org/wikipedia/commons/d/d7/Android_robot.svg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load)

        // Here you have a Glide Request Builder
        // Do what you want with it :)
        val requestBuilder: RequestBuilder<PictureDrawable> = GlideToVectorYou
                .init()
                .with(this)
                .requestBuilder

        // Customize request like you were using Glide normally
        requestBuilder
                .load((Uri.parse(IMAGE_URL)))
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imageview)
    }
}
