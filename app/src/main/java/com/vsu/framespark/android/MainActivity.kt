package com.vsu.framespark.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toGrid(view: View){
        val intent = Intent(this@MainActivity,Grid::class.java)
        startActivity(intent)
    }
}