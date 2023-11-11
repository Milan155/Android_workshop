package com.example.a5_fourassigment

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class Myadapter(var context: Context,var  list:MutableList<Dashboardmodel>) :RecyclerView.Adapter<Myadapter.MyView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {

        var inflater=LayoutInflater.from(context)
        var view=inflater.inflate(R.layout.designofboard,parent,false)
        return MyView(view)

    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.image.setImageResource(list.get(position).image)
        holder.txt.setText(list.get(position).text)

        holder.itemView.setOnClickListener {
            if (position==0)
            {
                val at=Intent(context.applicationContext,projectdetails::class.java)
                at.addFlags(FLAG_ACTIVITY_NEW_TASK)
                context.applicationContext.startActivity(at)

            }
            if (position==1)
            {
                val at2=Intent(context.applicationContext,projectviewdetails::class.java)
                at2.addFlags(FLAG_ACTIVITY_NEW_TASK)
                context.applicationContext.startActivity(at2)
            }

        }
    }

    override fun getItemCount(): Int {
        return list.size

    }
    class MyView(itemview: View) : RecyclerView.ViewHolder(itemview) {


        var image: ImageView = itemview.findViewById(R.id.img)
        var txt: TextView = itemview.findViewById(R.id.txt1)
    }

}



