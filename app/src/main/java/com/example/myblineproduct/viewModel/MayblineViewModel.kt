package com.example.myblineproduct.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.example.myblineproduct.model.MaybellineData
import com.example.myblineproduct.repository.MaybllineRepository
import kotlinx.coroutines.*

class MayblineViewModel : ViewModel() {

    private var maybline :MutableLiveData<List<MaybellineData>> = MutableLiveData()
    private var error : MutableLiveData<String> = MutableLiveData()
    private var repository =MaybllineRepository()

    var job:Job?=null


    fun getAPICall(){

        job= CoroutineScope(Dispatchers.IO).launch {
            Log.i("Dispatcher scope of IO","$this")
            var response=repository.getApiData()

            withContext(Dispatchers.Main){
                Log.i("Dispatcher scope MAIN","$this")
                if (response.isSuccessful){
                    maybline.value=response.body()
                }
                else{
                    error.value=response.errorBody().toString()
                }
            }

        }
    }

    fun getLiveData() :LiveData<List<MaybellineData>>{
        return maybline
    }
    fun getLiveDataerror() :LiveData<String>{
        return error
    }


}