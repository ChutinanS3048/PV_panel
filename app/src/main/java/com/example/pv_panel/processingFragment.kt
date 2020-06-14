package com.example.pv_panel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.pv_panel.databinding.FragmentProcessingBinding


class processingFragment : Fragment() {

    private  lateinit var binding: FragmentProcessingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        binding = FragmentProcessingBinding.inflate(layoutInflater)

        return binding.root

    }

//    private fun spinnerButton() {
//        val Level_light = arrayListOf<String>("50", "100" , "150" , "200")
//        val ArrayAdapter_Level = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, Level_light)
//        binding.spLevellight.adapter = ArrayAdapter_Level
//    }




}