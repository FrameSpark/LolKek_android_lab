package com.vsu.framespark.android

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)
        val arguments = intent.extras

        val nameText : TextView = findViewById(R.id.name)
        val nicknameText : TextView = findViewById(R.id.nickname)
        val jobText : TextView = findViewById(R.id.job)

        nameText.text = arguments!!.get("name").toString()
        nicknameText.text = arguments!!.get("nickname").toString()
        jobText.text = arguments!!.get("job").toString()
    }
}