package com.example.myblineproduct.repository

import com.example.myblineproduct.model.MaybellineData
import com.example.myblineproduct.network.ApiClient
import com.example.myblineproduct.network.ApiInterface
import retrofit2.Response

class MaybllineRepository {

    lateinit var apiInterface: ApiInterface

    public suspend fun getApiData(): Response<List<MaybellineData>>{
        apiInterface=ApiClient.getApiClient().create(ApiInterface::class.java)
        return apiInterface.getMayblline()
    }
}