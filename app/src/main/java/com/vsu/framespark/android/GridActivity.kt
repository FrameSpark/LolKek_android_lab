package com.vsu.framespark.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vsu.framespark.android.Adapters.CustomRecyclerAdapter
import com.vsu.framespark.android.Models.People
import com.vsu.framespark.android.Services.PeopleService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.security.AccessController.getContext

class GridActivity : AppCompatActivity() {

    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)
        //textView = findViewById(R.id.textView4)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        getAdvice()
    }

    fun getAdvice() {
        val callListPost = PeopleService.inctance?.JSONApi?.getAdvice()

        val callback = object : Callback<List<People>> {
            override fun onResponse(call: Call<List<People>>, response: Response<List<People>>) {
                //val post = response.body()
                //val data = mutableListOf<String>()
                //if(post != null && post.size >0) {
                //    for (i in 0..post.size-1) {
                //        var people = "${post!![i].name} - " + "${post!![i].job} -" + "${post!![i].nickname}"
                //        var name = "${post!![i].name}"
                //        data.add(name)
                //    }
               // }
                val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
                recyclerView.adapter = CustomRecyclerAdapter(response.body())
            }

            override fun onFailure(call: Call<List<People>>, t: Throwable) {
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext,  "Ошибка загрузки", duration)
                toast.show()
            }
        }
        callListPost?.enqueue(callback)
    }
}