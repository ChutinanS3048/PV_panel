package com.example.pv_panel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pv_panel.databinding.CustomDataListBinding
import com.example.pv_panel.models.JsonDemoResult
import com.example.pv_panel.models.ProductsResponse

class CustomDataListAdapter(private var dataList: List<ProductsResponse>?): RecyclerView.Adapter<CustomDataListAdapter.ViewHolder> (){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomDataListAdapter.ViewHolder {
        val  binding = CustomDataListBinding.inflate(LayoutInflater.from(parent.context), parent , false)
        return ViewHolder(binding.root,binding)
    }

    override fun getItemCount() = dataList?.size ?: 0

    override fun onBindViewHolder(holder: CustomDataListAdapter.ViewHolder, position: Int) {
        val binding = holder.binding

        dataList?.let { list ->
            val item = list [position]


            binding.textviewnameBoard.text= item.nameBoard
            binding.textviewlightIntensity.text= item.light_intensity
             binding.textviewmyDateTime.text=item.myDateTime
        }


    }

    inner class ViewHolder(view: View, val binding: CustomDataListBinding) : RecyclerView.ViewHolder(view){

    }

}