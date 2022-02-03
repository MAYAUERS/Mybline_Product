package com.example.myblineproduct.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object{

        val httpLoggingInterceptor=HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttpClient =OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
        val BASEURL="https://makeup-api.herokuapp.com/"
//https://makeup-api.herokuapp.com/api/v1/products.json?brand=maybelline
// https://makeup-api.herokuapp.com/products.json?brand=maybelline
        fun getApiClient() : Retrofit{
            return Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        }

    }
}