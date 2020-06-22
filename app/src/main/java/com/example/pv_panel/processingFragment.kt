package com.example.pv_panel
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.pv_panel.databinding.FragmentProcessingBinding
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import com.jjoe64.graphview.series.PointsGraphSeries
import kotlinx.android.synthetic.main.fragment_processing.view.*
import com.example.pv_panel.processingFragment as examplePv_panelProcessingFragment


class processingFragment : Fragment()  {

    private  lateinit var binding: FragmentProcessingBinding

    private lateinit var xySeries1: PointsGraphSeries<DataPoint>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        binding = FragmentProcessingBinding.inflate(layoutInflater)

        binding.graph.apply {
            val series1 = LineGraphSeries(
                arrayOf(
                    DataPoint(1.0, 1.0),
                    DataPoint(10.0, 10.0),
                    DataPoint(11.0, 11.0),
                    DataPoint(12.0, 12.0),
                    DataPoint(13.0, 13.0),
                    DataPoint(14.0, 14.0)))
            graph.addSeries(series1)

            series1.color = Color.RED
            series1.thickness = 2
            series1.isDrawBackground = true
            series1.isDrawDataPoints = true
            series1.isDrawDataPoints = false
            series1.backgroundColor = Color.parseColor("#0D000000")
            xySeries1 = PointsGraphSeries()
        }






        return binding.root

    }


//    private fun spinnerButton() {
//        val Level_light = arrayListOf<String>("50", "100" , "150" , "200")
//        val ArrayAdapter_Level = ArrayAdapter(context, android.R.layout.simple_list_item_1, Level_light)
//        binding.spLevellight.adapter = ArrayAdapter_Level
//    }

}