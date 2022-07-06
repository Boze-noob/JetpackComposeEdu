package com.applid.gym.ui.screens.profile_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.madrapps.plot.line.DataPoint
import com.madrapps.plot.line.LineGraph
import com.madrapps.plot.line.LinePlot


@Composable
fun WeightGraph() {

    val dataPoints = listOf(DataPoint(1.0F, 2.0F), DataPoint(1.4F, 3.0F) )

    Column(
        modifier = Modifier
        .padding(horizontal = 10.dp, vertical = 5.dp)
        ) {
        Text(text = "Weight graph", style = MaterialTheme.typography.h3)
        Spacer(modifier = Modifier.height(15.dp))
        LineGraph(
            plot = LinePlot(
                listOf(
                    LinePlot.Line(
                        dataPoints,
                        LinePlot.Connection(color = Color.Red),
                        LinePlot.Intersection(color = Color.Red),
                        LinePlot.Highlight(color = Color.Yellow),
                    )
                ),
                grid = LinePlot.Grid(Color.Transparent, steps = 4),
            ),
            modifier = Modifier.fillMaxWidth()
                .height(200.dp),
            
            onSelection = { xLine, points ->
                // Do whatever you want here
            }
        )


        
    }
}