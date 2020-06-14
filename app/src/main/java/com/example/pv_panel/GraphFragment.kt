package com.example.pv_panel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pv_panel.adapter.CustomDataListAdapter
import com.example.pv_panel.databinding.FragmentGraphBinding



class GraphFragment : Fragment() {
    private  lateinit var binding: FragmentGraphBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentGraphBinding.inflate(layoutInflater)

        binding.fragmentGraphRecyclerview.apply{
            adapter = CustomDataListAdapter()

            //import
            layoutManager = GridLayoutManager(context ,1)
            addItemDecoration(GridSpacingItemDecoration(1,10,true))
        }
        return binding.root
    }

}