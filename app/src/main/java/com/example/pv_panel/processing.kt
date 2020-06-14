package com.example.pv_panel

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.pv_panel.databinding.ActivityProcessing2Binding
import com.example.pv_panel.databinding.CustomTabMenuBinding
import com.example.pv_panel.adapter.SectionsPagerAdapter
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator


class processing : AppCompatActivity() {

    private lateinit var sectionsPagerAdapter: SectionsPagerAdapter
    private lateinit var binding: ActivityProcessing2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityProcessing2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        sectionsPagerAdapter = SectionsPagerAdapter(
            this,
            supportFragmentManager,
            lifecycle
        )

        setupViewPager()
        setupWidget()
        setupTab()




    }


    private fun setupTab() {
        TabLayoutMediator(binding.tabs, binding.viewPager,
            TabLayoutMediator.TabConfigurationStrategy{ tab ,position ->
                val binding = CustomTabMenuBinding.inflate(layoutInflater)

                binding.iconTab.setImageResource(sectionsPagerAdapter.tabIcon[position]) /////ตรงนี้ีี้รูปภาพ icon tab
                binding.textTab.text = sectionsPagerAdapter.tabText[position]

                tab.customView = binding.root
            }).attach()
    }

    private fun setupWidget() {

        binding.fab.setOnClickListener{view ->
            Snackbar.make(view , "Reace with your own action" , Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }


    private fun setupViewPager() {
        binding.viewPager.apply {
            adapter = sectionsPagerAdapter
        }.also {
            it.setPageTransformer(HorizontalFlipTransformation())
            it.registerOnPageChangeCallback(object  : ViewPager2.OnPageChangeCallback(){
                @SuppressLint("RestrictedApi")
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                    if (position == 0){
                        binding.fab.visibility = View.VISIBLE
                    }else{
                        binding.fab.visibility = View.INVISIBLE
                    }
                }
            })
        }
    }
}