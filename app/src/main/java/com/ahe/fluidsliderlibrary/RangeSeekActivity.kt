package com.ahe.fluidsliderlibrary

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ahe.fluidsliderlibrary.RangeSeekBar.Slidr
import android.graphics.Color.parseColor
import android.support.v4.content.ContextCompat


class RangeSeekActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_range_seek)


        val slidr = findViewById<Slidr>(R.id.slidr)

        slidr.max = 100f
        slidr.setTextMax("")
        //slidr.setBackgroundColor(ContextCompat.getColor(this,R.color.slider_bg))


        slidr.addStep(Slidr.Step("", 35f,ContextCompat.getColor(this,R.color.slider_fg)))
        slidr.addStep(Slidr.Step("", 50f,ContextCompat.getColor(this,R.color.slider_fg)))
        slidr.addStep(Slidr.Step("", 70f,ContextCompat.getColor(this,R.color.slider_fg)))


        slidr.addPointText(Slidr.PointText("", 20f))
        slidr.addPointText(Slidr.PointText("", 30f))
        slidr.addPointText(Slidr.PointText("", 40f))
        slidr.addPointText(Slidr.PointText("", 50f))
        slidr.addPointText(Slidr.PointText("", 70f))
        slidr.addPointText(Slidr.PointText(">70", 85f))

    }
}
