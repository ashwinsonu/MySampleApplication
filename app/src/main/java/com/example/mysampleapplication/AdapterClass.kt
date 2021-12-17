package com.example.mysampleapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class AdapterClass(var songs:MutableList<Dish_Data>): RecyclerView.Adapter<AdapterClass.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater:LayoutInflater= LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.items,parent,false)
        return ViewHolder(view)

    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dishName.text=songs[position].name
//        holder.dishType.text=songs[position].type
//        holder.dishPrice.text="${songs[position].price}$ per stock"
        Picasso.get().load(songs[position].url).into(holder.dishImage);
    }
    override fun getItemCount(): Int {
        return songs.size
    }
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val dishImage=itemView.findViewById<ImageView>(R.id.dishimage)
        val dishName=itemView.findViewById<TextView>(R.id.dishname)
//        val dishType=itemView.findViewById<TextView>(R.id.dishtype)
//        val dishPrice=itemView.findViewById<TextView>(R.id.dishprice)
    }

}