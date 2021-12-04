package com.vsu.framespark.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.vsu.framespark.android.Models.People
import com.vsu.framespark.android.Services.PeopleService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Grid : AppCompatActivity() {

    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)
        textView = findViewById(R.id.textView4)
        getAdvice()
    }

    fun getAdvice() {
        val callListPost = PeopleService.inctance?.JSONApi?.getAdvice()

        val callback = object : Callback<List<People>> {
            override fun onResponse(call: Call<List<People>>, response: Response<List<People>>) {
                val post = response.body()
                if(post != null && post.size >0) {
                    textView.setText("")
                    for (i in 0..post.size-1) {
                        var people = "${post!![i].name} - " + "${post!![i].job} -" + "${post!![i].nickname}"
                        textView.append(people)
                    }
                }
            }

            override fun onFailure(call: Call<List<People>>, t: Throwable) {
                textView.append("Error: ${t.message}")
            }
        }
        callListPost?.enqueue(callback)
    }
}