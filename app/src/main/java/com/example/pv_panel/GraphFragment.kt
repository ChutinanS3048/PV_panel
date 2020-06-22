package com.example.pv_panel

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pv_panel.adapter.CustomDataListAdapter
import com.example.pv_panel.databinding.FragmentGraphBinding
import com.example.pv_panel.models.JsonDemoResult
import com.example.pv_panel.models.ProductsResponse
import com.example.pv_panel.services.APIClient
import com.example.pv_panel.services.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create


class GraphFragment : Fragment() {
    private lateinit var binding: FragmentGraphBinding
    private lateinit var customAdapter: CustomDataListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentGraphBinding.inflate(layoutInflater)
        customAdapter = CustomDataListAdapter(null)   ///ใส่ null

        setupWidget()
        feedNetwork()

        
        return binding.root
    }

    private fun feedNetwork() {
        binding.swipeRefresh.isRefreshing = true
        APIClient.getClient().create(APIService::class.java).getProducts().let { call ->
            Log.d("debug_url" , call.request().url().toString())

            call.enqueue(object : Callback<List<ProductsResponse>>{
                override fun onFailure(call: Call<List<ProductsResponse>>, t: Throwable) {
                    context?.showToast(t.message.toString())
                    binding.swipeRefresh.isRefreshing = false
                }

                override fun onResponse(
                    call: Call<List<ProductsResponse>>,
                    response: Response<List<ProductsResponse>>
                ) {
                    if (response.isSuccessful){
                        binding.fragmentGraphRecyclerview.adapter = CustomDataListAdapter(response.body())
                        context?.showToast(response.body().toString())
                    }
                    else{
                        context?.showToast(response.message())
                    }
                    binding.swipeRefresh.isRefreshing = false

                }

            })
        }

    }

    private fun setupWidget() {
        binding.fragmentGraphRecyclerview.apply{
            adapter = customAdapter

            //import
            layoutManager = GridLayoutManager(context ,1)

        }.also {
            it.addItemDecoration(GridSpacingItemDecoration(1,20,true))
            it.setHasFixedSize(true)
        }
        binding.swipeRefresh.setOnRefreshListener {
            feedNetwork()
        }
    }

}