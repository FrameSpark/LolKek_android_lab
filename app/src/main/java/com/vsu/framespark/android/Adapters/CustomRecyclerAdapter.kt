package com.vsu.framespark.android.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.vsu.framespark.android.DetailedActivity
import com.vsu.framespark.android.Models.People
import com.vsu.framespark.android.R

class CustomRecyclerAdapter(private val names: List<People>?) :
    RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {
    //val context = context;
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var largeTextView: TextView? = null
        var smallTextView: TextView? = null

        init {
            largeTextView = itemView.findViewById(R.id.textViewLarge)
            smallTextView = itemView.findViewById(R.id.textViewSmall)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var name = ""
        var nickname = ""

        if(names?.get(position)?.name != null)
            name = names?.get(position)?.name!!
        if(names?.get(position)?.nickname != null)
            nickname = names?.get(position)?.nickname!!

        holder.largeTextView?.text = name
        holder.smallTextView?.text = nickname

        //Листенер на открытие
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailedActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("nickname", nickname)
            intent.putExtra("job", names?.get(position)?.job)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return names!!.size
    }
}