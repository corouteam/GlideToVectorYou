package com.github.twocoffeesoneteam.glidetovectoryou_example

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYouListener
import kotlinx.android.synthetic.main.activity_load.*

class NormalLoadActivity : AppCompatActivity() {

    private val IMAGE_URL = "https://upload.wikimedia.org/wikipedia/commons/d/d7/Android_robot.svg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load)

        GlideToVectorYou
                .init()
                .with(this)
                .withListener(object : GlideToVectorYouListener{
                    override fun onLoadFailed() {
                        Toast.makeText(baseContext, "Loading failed", Toast.LENGTH_SHORT).show()
                    }

                    override fun onResourceReady() {
                        Toast.makeText(baseContext, "Image ready", Toast.LENGTH_SHORT).show()
                    }
                })
                .load(Uri.parse(IMAGE_URL), imageview)
    }
}
