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

        //slidr.max = 500f
        slidr.addStep(Slidr.Step("test", 100f, Color.parseColor("#d7e3ef"), Color.parseColor("#1969c5")))
        slidr.addStep(Slidr.Step("test2", 300f, Color.parseColor("#d7e3ef"), Color.parseColor("#1969c5")))
        slidr.addStep(Slidr.Step("test3", 600f, Color.parseColor("#d7e3ef"), Color.parseColor("#1969c5")))
        slidr.addStep(Slidr.Step("test4", 900f, Color.parseColor("#d7e3ef"), Color.parseColor("#1969c5")))
        //slidr.setti

        //slidr.addStep(Slidr.Step("test", 200f, Color.parseColor("#007E90"), Color.BLUE))
        //slidr.addStep(Slidr.Step("test", 300f, Color.parseColor("#007E90"), Color.YELLOW))
        //slidr.addStep(Slidr.Step("test", 400f, Color.parseColor("#007E90"), Color.GREEN))

        //slidr.setTextMax("max\nvalue")
        //slidr.currentValue = 300f
        //slidr.currentValue = 0f
        /*slidr.setListener(object : Slidr.Listener {
            override fun valueChanged(slidr: Slidr, currentValue: Float) {

            }

            fun bubbleClicked(slidr: Slidr) {

            }
        })*/
    }
}
