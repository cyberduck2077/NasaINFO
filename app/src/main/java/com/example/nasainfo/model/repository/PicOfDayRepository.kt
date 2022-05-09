package com.example.nasainfo.model.repository

import com.example.nasainfo.data.OfADayData
import retrofit2.Call

interface PicOfDayRepository {
    fun getOfADayData(_params:Map<String, String>): Call<OfADayData>
}