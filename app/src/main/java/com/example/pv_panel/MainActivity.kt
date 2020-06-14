package com.example.pv_panel

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pv_panel.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


         binding = ActivityMainBinding.inflate(layoutInflater)
         setContentView(binding.root)


        setupWidget()
    }

    private fun setupWidget(){
        binding.workHistoryBtn.setOnClickListener {
            work_history()

        }
        binding.processingBtn.setOnClickListener {
            processButton()
        }
    }

    private fun work_history() {
        val intent = Intent(applicationContext, historyActivity::class.java)
        startActivity(intent)
    }

    private fun processButton() {
        val intent = Intent(applicationContext, processing::class.java)
        startActivity(intent)

    }


}
