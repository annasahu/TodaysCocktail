package com.example.todayscocktail.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.todayscocktail.R
import com.example.todayscocktail.network.Cocktail

class CocktailsAdapter(): RecyclerView.Adapter<CocktailsAdapter.CocktailsItemViewHolder>() {
    var dataList = listOf<Cocktail>()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    private lateinit var context: Context

    inner class CocktailsItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val cocktailName: TextView = itemView.findViewById(R.id.name) //colocar id do nome
        val cocktailThumb: ImageView = itemView.findViewById(R.id.thumb) //colocar id thumb

        fun loadData(name: String, thumb: String) {
            cocktailName.text = name
            Glide.with(itemView.context)
                .load(thumb)
                .into(cocktailThumb)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailsItemViewHolder {
        context = parent.context
        return CocktailsItemViewHolder(LayoutInflater.from(context)
            .inflate(R.layout.item_view, parent, false)) //alterar nome da recycleview
    }

    override fun onBindViewHolder(holder: CocktailsItemViewHolder, position: Int) {
        val cockailItemToShow = dataList.get(position)

        holder.loadData(cockailItemToShow.name, cockailItemToShow.thumbUrl)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}