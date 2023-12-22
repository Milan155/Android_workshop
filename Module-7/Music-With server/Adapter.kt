package com.example.musicplayerwithserver

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class Adapter(context: Context, var list: List<Model>):RecyclerView.Adapter<Adapter.Myview>()
{
    lateinit var apiinterface: Apiinterface

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):Myview {

        var layoutInflater = LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.design_list, parent, false)
        return Myview(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder:Myview, position: Int) {
        holder.textSongnm.setText(list.get(position).Music_Name)
        holder.textSingernm.setText(list.get(position).Singer_Name)
        Picasso.get().load(list.get(position).Pic).into(holder.imageview)


        holder.itemView.setOnClickListener {

            holder.itemView.setOnClickListener {

                var i = Intent(context, Songplay::class.java)
                i.putExtra("mypos", position)
                i.putExtra("songname", list.get(position).Music_Name)
                i.putExtra("singernm", list.get(position).Singer_Name)
                i.putExtra("img", list.get(position).Pic)
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(i)
            }
        }

    }

    class Myview(Itemview:View):RecyclerView.ViewHolder(Itemview)
    {
        var textSongnm: TextView = Itemview.findViewById(R.id.txtsong_name)
        var textSingernm: TextView = Itemview.findViewById(R.id.txtsinger_name)
        var imageview: CircleImageView = Itemview.findViewById(R.id.img1)

    }

}

