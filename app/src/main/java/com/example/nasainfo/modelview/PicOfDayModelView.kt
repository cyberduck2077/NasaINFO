package com.example.nasainfo.modelview

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nasainfo.Constants
import com.example.nasainfo.data.OfADayData
import com.example.nasainfo.model.repository.PicOfDayRepository
import com.example.nasainfo.model.repository.PicOfDayRepositoryImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class PicOfDayModelView {

    private val _dayinfo = MutableLiveData<OfADayData?>()
    val dayinfo: LiveData<OfADayData?> = _dayinfo


    @RequiresApi(Build.VERSION_CODES.O)
    private fun getTodayDate():String{
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val formatted = current.format(formatter) as String
        Log.d("TTT","today: ${formatted}")
        return formatted
    }

    private val mPicOfDayRepository: PicOfDayRepository = PicOfDayRepositoryImpl()


    @RequiresApi(Build.VERSION_CODES.O)
    fun getDayInfo(){


        val _params = mapOf<String,String>("api_key" to Constants().API_KEY, "date" to getTodayDate(), "concept_tags" to "False")

        val response = mPicOfDayRepository.getOfADayData(_params)

        response.enqueue(object :Callback<OfADayData>{
            override fun onResponse(call: Call<OfADayData>, response: Response<OfADayData>) {
                Log.d("TTT","onFailure11 : code is ${response.code()}")
                if(response.body()!=null){
                    _dayinfo.postValue(response.body() as OfADayData)
                }
            }

            override fun onFailure(call: Call<OfADayData>, t: Throwable) {
                Log.d("TTT","onFailure : ${t.message}")
            }

        })

    }
}