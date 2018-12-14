package com.ahe.fluidsliderlibrary

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ahe.fluidsliderlibrary.FluidSliderLib.FluidSlider
import android.support.v4.view.ViewCompat.animate
import android.transition.Slide
import android.util.Log
import android.view.MotionEvent
import android.view.animation.*
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.animation.Animator
import android.animation.AnimatorListenerAdapter




class MainActivity : AppCompatActivity() {

    var max = 8.0
    var min = 0.0
    enum class SliderType
    {
        Normal,
        Overtime
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val slider = findViewById<FluidSlider>(R.id.fluidSlider)


        var plusSize=imageView_plus.layoutParams.width

        /*imageView_plus.setOnClickListener{
                max=24.0
                slider.endText = "$max"
                slider.position=convertHourtoPos(8f)
        }



        slider.positionListener = {
            var temp=convertPostoHour(it)
            slider.bubbleText = temp
        }

        slider.position = 0f
        slider.startText ="$min"
        slider.endText = "$max"
        slider.dayType=FluidSlider.DayType.Normal

        Toast.makeText(this@MainActivity,slider.width.toString(),Toast.LENGTH_SHORT).show()

        slider.beginTrackingListener = { textView.visibility = View.INVISIBLE }
        slider.endTrackingListener = { textView.visibility = View.VISIBLE

            if(slider.dayType==FluidSlider.DayType.Normal && slider.position==1f)
            {
                val anim = ValueAnimator.ofInt(slider.measuredWidth, slider.measuredWidth-plusSize)
                anim.addUpdateListener { valueAnimator ->
                    val `val` = valueAnimator.animatedValue as Int
                    val layoutParams = slider.layoutParams
                    layoutParams.width = `val`
                    slider.layoutParams=layoutParams
                }
                anim.duration = 1000
                anim.start()

                slider.dayType=FluidSlider.DayType.Overtime
            }
            else if(slider.dayType==FluidSlider.DayType.Overtime && slider.position<=0.33f)
            {
                val anim = ValueAnimator.ofInt(slider.measuredWidth, slider.measuredWidth+plusSize)
                anim.addUpdateListener { valueAnimator ->
                    val `val` = valueAnimator.animatedValue as Int
                    val layoutParams = slider.layoutParams
                    layoutParams.width = `val`
                    slider.layoutParams=layoutParams
                }
                anim.duration = 1000
                anim.start()

                anim.addListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        max=8.0
                        slider.endText = "$max"
                        slider.position=convertHourtoPos(convertStringToHour(slider.bubbleText!!))
                    }
                })

                slider.dayType=FluidSlider.DayType.Normal


            }

        }*/
    }



    /*fun convertPostoHour(value: Float):String
    {
        val value = (value * (6*max)).toInt()
        val hour=value/6
        val min=((value-(hour*6))*10)
        var minString = "00"
        if (min != 0){
            minString = min.toString()
        }
        return "$hour:$minString"
    }*/
    /*fun convertHourtoPos(value: Float):Float
    {
        var str=value.toString()
        var temp=str.split(".")
        return ((temp[0].toFloat()*6)+(temp[1].toFloat()))/((6*max).toInt())
    }*/

    fun convertStringToHour(str: String):Float
    {
        return str.replace(":",".").toFloat()
    }
}
