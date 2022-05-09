package com.example.nasainfo.model.repository

import com.example.nasainfo.Constants
import com.example.nasainfo.data.OfADayData
import com.example.nasainfo.model.retrofit.InterfaceAPI
import retrofit2.Call

class PicOfDayRepositoryImpl: PicOfDayRepository {

    private val interfaceAPI = InterfaceAPI.create()

    override fun getOfADayData(_params:Map<String, String>): Call<OfADayData> {
        return interfaceAPI.getOfADayData(_params)
    }

}