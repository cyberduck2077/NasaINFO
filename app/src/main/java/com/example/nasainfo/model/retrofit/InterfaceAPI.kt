package com.example.nasainfo.model.retrofit

import com.example.nasainfo.BuildConfig
import com.example.nasainfo.Constants
import com.example.nasainfo.data.OfADayData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.QueryMap


interface InterfaceAPI {

    @GET("/planetary/apod")//? api_key=DEMO_KEY & date=2014-10-01 & concept_tags=True
    fun getOfADayData(@QueryMap option: Map<String, String>): Call<OfADayData>


    companion object {


        fun create(): InterfaceAPI {

            /*
            * Добавляем логирование запросов
            * */
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)

            val client: OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants().BASE_URL)
                .client(client)
                .build()
            return retrofit.create(InterfaceAPI::class.java)

        }

    }
}