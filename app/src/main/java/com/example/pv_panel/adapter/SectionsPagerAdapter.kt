package com.example.pv_panel.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pv_panel.GraphFragment
import com.example.pv_panel.R
import com.example.pv_panel.processingFragment

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager , lifecycle: Lifecycle)
    : FragmentStateAdapter(fm, lifecycle) {

    val tabIcon: Array<Int> = arrayOf(R.drawable.comeback, R.drawable.comeback) //เปลี่ยนรูปภาพ
    val tabText: Array<String> = arrayOf(*context.resources.getStringArray(R.array.tab_title))




    override fun getItemCount() = tabIcon.size

    override fun createFragment(position: Int): Fragment {
        //การเขียน switch case แบบ expression
        return  when(position) {
            0 -> {
                 processingFragment()
            }
            else -> {
                 GraphFragment()
            }
        }
    }
}

