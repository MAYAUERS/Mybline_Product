package com.example.myblineproduct.network

import com.example.myblineproduct.model.MaybellineData
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    //http://makeup-api.herokuapp.com/api/v1/products.json?brand=maybelline

    @GET("api/v1/products.json?brand=maybelline")
    suspend fun getMayblline(): Response<List<MaybellineData>>
}