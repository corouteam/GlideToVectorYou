package com.github.twocoffeesoneteam.glidetovectoryou_example

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import kotlinx.android.synthetic.main.activity_load.*

class SimpleLoadActivity : AppCompatActivity() {

    private val IMAGE_URL = "https://upload.wikimedia.org/wikipedia/commons/d/d7/Android_robot.svg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load)

        GlideToVectorYou.justLoadImage(this, Uri.parse(IMAGE_URL), imageview)
    }
}
