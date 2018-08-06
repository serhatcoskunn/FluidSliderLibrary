package com.ahe.fluidsliderlibrary

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ahe.fluidsliderlibrary.FluidSliderLib.FluidSlider
import android.support.v4.view.ViewCompat.animate
import android.view.animation.*
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    enum class SliderType
    {
        Normal,
        Anormal
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var globalPos:Float=0f

        val textView = findViewById<TextView>(R.id.textView)

        val max = 8.0
        val min = 0.0
        val total = max - min

        val slider = findViewById<FluidSlider>(R.id.fluidSlider)
        //slider.positionListener = { pos -> slider.bubbleText = "${min + (total  * pos).toInt()}" }
        slider.positionListener = {

            pos -> slider.bubbleText = getSliderText((min + (total  * pos)).toFloat().format(1))
            if(pos==1f)
                slider.dayType=FluidSlider.DayType.Overtime
            else
                slider.dayType=FluidSlider.DayType.Normal


        }
        slider.position = 0.3f
        slider.startText ="$min"
        slider.endText = "$max"
        slider.dayType=FluidSlider.DayType.Normal

        slider.beginTrackingListener = { textView.visibility = View.INVISIBLE }
        slider.endTrackingListener = { textView.visibility = View.VISIBLE

            if(slider.dayType==FluidSlider.DayType.Overtime)
            {
                //Toast.makeText(this@MainActivity,"Tıkandı",Toast.LENGTH_SHORT).show()
                val scal = ScaleAnimation(1f, 1.1f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.5.toFloat(), Animation.RELATIVE_TO_SELF, 0.5.toFloat())
                scal.duration = 1000
                scal.fillAfter = true
                slider.animation = scal
            }
            else
            {
                //Toast.makeText(this@MainActivity,"Tıkandı",Toast.LENGTH_SHORT).show()
                val scal = ScaleAnimation(1.1f, 1f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.5.toFloat(), Animation.RELATIVE_TO_SELF, 0.5.toFloat())
                scal.duration = 1000
                scal.fillAfter = true
                slider.animation = scal
            }
        }


        //val bounceInterpolator = BounceInterpolator()
        //val anim = ObjectAnimator.ofFloat(slider, "translationY", 0f, -200f)
        //anim.setInterpolator(bounceInterpolator)
        //anim.setDuration(1100).start()

        /*textView.setOnClickListener {
            Toast.makeText(this@MainActivity,"Tıkandı",Toast.LENGTH_SHORT).show()
            val scal = ScaleAnimation(0.5f, 1f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.5.toFloat(), Animation.RELATIVE_TO_SELF, 0.5.toFloat())
            scal.duration = 500
            scal.fillAfter = true
            slider.animation = scal
        }*/


    }






    fun Float.format(digits: Int) = java.lang.String.format("%.${digits}f", this)

    fun getSliderText(value: String):String
    {
        var allStr:List<String>?=null
        if(value.contains("."))
            allStr=value.split(".")
        else
            allStr=value.split(",")

        return "${allStr[0]}s ${allStr[1]}d"
    }

}
