package com.example.nasainfo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.nasainfo.R

class StartActivity : AppCompatActivity() {

    lateinit var button1: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        initView()
        initOnClickListener()
    }

    private fun initOnClickListener() {
        button1.setOnClickListener{
            val intent = Intent(this, PictureOfTheDayActivity::class.java)
            startActivity(intent)
        }
    }


    private fun initView() {
        button1 = findViewById(R.id.btn1_id)
    }

}