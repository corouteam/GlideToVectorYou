package com.github.twocoffeesoneteam.glidetovectoryou_example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun simpleLoad(view: View){
        openActivity(SimpleLoadActivity::class.java)
    }


    fun normalLoad(view: View){
        openActivity(NormalLoadActivity::class.java)
    }


    fun advancedLoad(view: View){
        openActivity(AdvancedLoadActivity::class.java)
    }

    private fun openActivity(cls: Class<*>) {
        startActivity(Intent(this, cls))
    }

}
