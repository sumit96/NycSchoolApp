package com.example.nycschoolapp.network

import com.example.nycschoolapp.model.ParagraphModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MySchoolApi {
    @GET("resource/s3k6-pzi2.json")
    suspend fun getSchoolList(): List<ParagraphModel>

    companion object{
        var schoolApi:MySchoolApi?= null
        fun getInstanceData():MySchoolApi{
            if(schoolApi == null)
            {
                schoolApi = Retrofit.Builder()
                    .baseUrl("https://data.cityofnewyork.us/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(MySchoolApi::class.java)
            }
            return schoolApi!!
        }
    }
}