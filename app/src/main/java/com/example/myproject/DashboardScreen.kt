package com.example.myproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.myproject.model.Model

class DashboardScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_screen)
        supportActionBar?.hide()

        val rvPopularProduct: RecyclerView = findViewById(R.id.rvPopularProduct)
        val data = arrayListOf<Model>(
            Model(R.drawable.pic1, "Macbook Pro 13 M2 Chip", "$125", "25"),
            Model(R.drawable.pic2, "Playstation 5", "$400", "100"),
        )

    }
}