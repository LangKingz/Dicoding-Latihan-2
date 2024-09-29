package com.example.latihandicoding4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ListHeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_sepatu, parent, false)
        return ListViewHolder(view)
    }
    override fun getItemCount(): Int = listHero.size



    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name,description,photo) = listHero[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.Description.text = description
        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context,"kamu Memilih ${listHero[holder.adapterPosition].name}",Toast.LENGTH_SHORT).show()
        }

    }


    class ListViewHolder(ItemView: View) :RecyclerView.ViewHolder(ItemView) {
        val imgPhoto : ImageView = itemView.findViewById(R.id.image_sepatu)
        val tvName : TextView = itemView.findViewById(R.id.nama_sepatu)
        val Description : TextView = itemView.findViewById(R.id.deskripsi)
    }
}