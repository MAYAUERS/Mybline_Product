package com.example.myblineproduct.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myblineproduct.R
import com.example.myblineproduct.adapter.MayblineAdapter
import com.example.myblineproduct.model.MaybellineData
import com.example.myblineproduct.viewModel.MayblineViewModel

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var mayblineAdapter: MayblineAdapter
    lateinit var viewModel: MayblineViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(this)

        viewModel=ViewModelProvider(this).get(MayblineViewModel::class.java)
        viewModel.getLiveData().observe(this,Observer<List<MaybellineData>>{

            mayblineAdapter=MayblineAdapter(it as ArrayList<MaybellineData>)
            recyclerView.adapter=mayblineAdapter
            mayblineAdapter.notifyDataSetChanged()
        })

        viewModel.getAPICall()

        viewModel.getLiveDataerror().observe(this,Observer<String>{
            Toast.makeText(this,"Error ",Toast.LENGTH_SHORT).show()
        })
    }
}