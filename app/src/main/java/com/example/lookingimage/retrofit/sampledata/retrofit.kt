package com.example.lookingimage.retrofit.sampledata

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

val loggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

val httpClient = OkHttpClient.Builder().apply {
    addInterceptor(loggingInterceptor)
}

val retrofit = Retrofit.Builder()
    .baseUrl("https://dapi.kakao.com")
    .client(httpClient.build())
    .addConverterFactory(GsonConverterFactory.create())
    .build()


class RetrofitConnection {


    companion object {

        private const val BASE_URL = "https://dapi.kakao.com/v2/search/image"
        private var INSTANCE: Retrofit? = null

        fun getInstance(): Retrofit {
            if(INSTANCE == null) {
                INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) // 1)
                    .build()
            }
            return INSTANCE!!
        }
    }
}