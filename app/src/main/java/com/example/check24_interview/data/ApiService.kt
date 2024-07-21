package com.example.check24_interview.data

import com.example.check24_interview.common.Constant.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("/products-test.json")
    suspend fun getDataFromApi(): ApiDataModel

}
