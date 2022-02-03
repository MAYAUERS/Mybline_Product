package com.example.myblineproduct.adapter

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myblineproduct.R
import com.example.myblineproduct.model.MaybellineData

class MayblineAdapter(private var mayblline:ArrayList<MaybellineData>) :RecyclerView.Adapter<MayblineAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.maybline_item,parent,false)
        return MyViewHolder(view)
    }

    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        var name=itemView.findViewById<TextView>(R.id.tv_name)
        var price=itemView.findViewById<TextView>(R.id.tv_price)
        var brand=itemView.findViewById<TextView>(R.id.tv_brand)
        var thumbnail=itemView.findViewById<ImageView>(R.id.imageView_icon)

        fun bindView(maybellineData: MaybellineData){
            name.text=maybellineData.name
            price.text=maybellineData.price
            brand.text=maybellineData.brand

            var url=maybellineData.image_link

            Glide.with(thumbnail).load(url).into(thumbnail)

        }

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindView(mayblline[position])
    }

    override fun getItemCount(): Int {
        return mayblline.size
    }
}