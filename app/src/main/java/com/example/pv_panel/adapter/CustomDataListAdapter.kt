package com.example.pv_panel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pv_panel.databinding.CustomDataListBinding

class CustomDataListAdapter: RecyclerView.Adapter<CustomDataListAdapter.ViewHolder> (){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomDataListAdapter.ViewHolder {
        val  binding = CustomDataListBinding.inflate(LayoutInflater.from(parent.context), parent , false)
        return ViewHolder(binding.root,binding)
    }

    override fun getItemCount() = 100

    override fun onBindViewHolder(holder: CustomDataListAdapter.ViewHolder, position: Int) {
        val binding = holder.binding

        val lorem = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
        binding.textviewName.text= lorem
        binding.textviewDetail.text=lorem
        binding.textviewPrice.text="15 V"
        binding.textviewStock.text="25 A"
    }

    inner class ViewHolder(view: View, val binding: CustomDataListBinding) : RecyclerView.ViewHolder(view){

    }

}