package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var wishList: List<Wish>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameEditText = findViewById<EditText>(R.id.nameET)
        val urlEditText = findViewById<EditText>(R.id.urlET)
        val priceEditText = findViewById<EditText>(R.id.priceET)
        val addButton = findViewById<Button>(R.id.addBT)

        wishList = WishData.getWish()

        val wishRecyclerView = findViewById<RecyclerView>(R.id.wishRV)
        val wishAdapter = WishAdapter(this, wishList)
        wishRecyclerView.adapter = wishAdapter
        wishRecyclerView.layoutManager = LinearLayoutManager(this)

        addButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val url = urlEditText.text.toString()
            val price = priceEditText.text.toString()

            if (name.isEmpty() || url.isEmpty() || price.isEmpty()) {
                Toast.makeText(this, "Fields need to be filled.", Toast.LENGTH_SHORT).show()

            }

            else {
                nameEditText.text.clear()
                urlEditText.text.clear()
                priceEditText.text.clear()

                WishData.insertWish(name, url, price.toDouble())
                wishAdapter.notifyDataSetChanged()

            }

        }

    }
}