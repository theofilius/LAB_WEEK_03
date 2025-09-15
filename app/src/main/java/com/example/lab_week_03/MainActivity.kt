package com.example.lab_week_03

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), CoffeeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSelected(id: Int) {
        val detailFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_detail) as DetailFragment
        detailFragment.setCoffeeData(id)
    }
}

