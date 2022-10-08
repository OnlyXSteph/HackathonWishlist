package com.example.wishlist

class WishData {
    companion object {
        private var wishlist: MutableList<Wish> = ArrayList()

        fun insertWish(name: String, url: String, price: Double) {
            wishlist.add(Wish(name, url, String.format("$%.2f", price)))
        }

        fun getWish(): List<Wish> {
            return wishlist
        }
    }
}