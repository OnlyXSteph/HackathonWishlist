package com.example.wishlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishAdapter(private val context: Context, private val wishes: List<Wish>): RecyclerView.Adapter<WishAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private var nameTextView: TextView
        private var urlTextView: TextView
        private var priceTextView: TextView

        init {
            nameTextView = itemView.findViewById(R.id.nameTV)
            urlTextView = itemView.findViewById(R.id.urlTV)
            priceTextView = itemView.findViewById((R.id.priceTV))
        }

        fun bind(wish: Wish){
            nameTextView.text = wish.name
            urlTextView.text = wish.url
            priceTextView.text = wish.price
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.wishlist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wish = wishes[position]
        holder.bind(wish)
    }

    override fun getItemCount(): Int {
        return wishes.size
    }
}