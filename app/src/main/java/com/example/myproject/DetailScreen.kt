package com.example.myproject

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class DetailScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_screen)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            // Buat intent untuk berpindah ke CartScreen
            val intent = Intent(this, CartScreen::class.java)
            startActivity(intent)
        }
        val ibShare = findViewById<ImageButton>(R.id.ibShare)
        val ibBookmark = findViewById<ImageButton>(R.id.ibBookmark)

// Handling Share Button Click
        ibShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Contoh pesan untuk dibagikan")
            startActivity(Intent.createChooser(shareIntent, "Bagikan lewat"))

            // Anda dapat mengganti "Contoh pesan untuk dibagikan" dengan pesan yang ingin Anda bagikan.
        }

// Handling Bookmark Button Click
        var isBookmarked = false

        ibBookmark.setOnClickListener {
            isBookmarked = !isBookmarked
            val tintColor = if (isBookmarked) Color.RED else Color.BLACK
            ibBookmark.backgroundTintList = ColorStateList.valueOf(tintColor)
            Toast.makeText(this, if (isBookmarked) "Item tersimpan" else "Item unbookmarked", Toast.LENGTH_SHORT).show()
        }
    }
}