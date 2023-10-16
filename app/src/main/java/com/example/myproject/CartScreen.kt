package com.example.myproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class CartScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart_screen)

        val tvTotal = findViewById<TextView>(R.id.tvTotal)
        var Total = 2500000
        tvTotal.text = Total.toString()

        val plusBtn = findViewById<ImageButton>(R.id.plusBtn)
        val minusBtn = findViewById<ImageButton>(R.id.minusBtn)
        val numberItemTxt = findViewById<TextView>(R.id.numberItemTxt)
        val hargaBarang = findViewById<TextView>(R.id.hargaBarang)

        plusBtn.setOnClickListener {
            val quantity = numberItemTxt.text.toString().toInt()
            if (quantity < MAX_ITEM) {
                val newQuantity = quantity + 1
                numberItemTxt.text = newQuantity.toString()
                Total = hargaBarang.text.toString().toInt() * newQuantity
                tvTotal.text = Total.toString()
            }
        }


        minusBtn.setOnClickListener {
            val quantity = numberItemTxt.text.toString().toInt()
            if (quantity > 1) {
                numberItemTxt.text = (quantity - 1).toString()
                Total -= hargaBarang.text.toString().toInt()
                tvTotal.text = Total.toString()
            }
        }


    }
}