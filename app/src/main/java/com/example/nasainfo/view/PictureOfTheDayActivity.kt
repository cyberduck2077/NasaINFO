package com.example.nasainfo.view

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.nasainfo.R
import com.example.nasainfo.modelview.PicOfDayModelView
import com.squareup.picasso.Picasso

lateinit var img_view: AppCompatImageView
lateinit var txt_View: AppCompatTextView

private val mModelView:PicOfDayModelView = PicOfDayModelView()

class PictureOfTheDayActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture_of_the_day)

        initViews()
        initObservers()
        mModelView.getDayInfo()
    }

    private fun initObservers() {
        mModelView.apply {
            dayinfo.observe(this@PictureOfTheDayActivity){
                if (it != null) {
                    txt_View.text = it.explanation
                    Picasso.get()
                        .load(it.url)
                        .resize(2000, 1000)
                        .centerInside()
                        .into(img_view)
                }
            }
        }
    }


    private fun initViews() {
        img_view = findViewById(R.id.img_pic_of_day_id)
        txt_View = findViewById(R.id.txt_info_day_id)
    }
}