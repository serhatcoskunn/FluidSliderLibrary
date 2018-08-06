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
import android.view.animation.*
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


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

        var plusSize=imageView_plus.layoutParams.width


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

        Toast.makeText(this@MainActivity,slider.width.toString(),Toast.LENGTH_SHORT).show()

        slider.beginTrackingListener = { textView.visibility = View.INVISIBLE }
        slider.endTrackingListener = { textView.visibility = View.VISIBLE



            if(slider.dayType==FluidSlider.DayType.Overtime)
            {

                //val scal = ScaleAnimation(1f, 1.1f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.5.toFloat(), Animation.RELATIVE_TO_SELF, 0.5.toFloat())
                /*val scal = ScaleAnimation(1f, 1.5f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f)
                scal.setAnimationListener(object :Animation.AnimationListener{
                    override fun onAnimationRepeat(p0: Animation?) {

                    }

                    override fun onAnimationEnd(p0: Animation?) {
                        val params = slider.layoutParams as ConstraintLayout.LayoutParams
                        //params.height = 520
                        //params.width = 0
                        params.layoutAnimationParameters
                        slider.layoutParams=params
                        slider.requestLayout()

                    }

                    override fun onAnimationStart(p0: Animation?) {

                    }


                })

                scal.duration = 1000
                scal.fillAfter = true
                slider.animation = scal*/
                /*val anim = ValueAnimator.ofInt(slider.measuredWidth, 800)
                anim.addUpdateListener { valueAnimator ->
                    val `val` = valueAnimator.animatedValue as Int
                    val layoutParams = slider.layoutParams
                    layoutParams.width = `val`
                    slider.layoutParams=layoutParams
                }
                anim.duration = 1000
                anim.start()*/

                val anim = ValueAnimator.ofInt(slider.measuredWidth, slider.measuredWidth-plusSize)
                anim.addUpdateListener { valueAnimator ->
                    val `val` = valueAnimator.animatedValue as Int
                    val layoutParams = slider.layoutParams
                    layoutParams.width = `val`
                    slider.layoutParams=layoutParams
                }
                anim.duration = 1000
                anim.start()


                //slider.invalidate()
                //slider.offsetLeftAndRight(100)

            }
            else
            {
                //slider.layoutParams.width=10
                //val scal = ScaleAnimation(1.1f, 1f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.5.toFloat(), Animation.RELATIVE_TO_SELF, 0.5.toFloat())
                //val scal = ScaleAnimation(2f, 1f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f)
                //scal.duration = 1000
                //scal.fillAfter = true
                //slider.animation = scal


            }
            Toast.makeText(this@MainActivity,slider.width.toString(),Toast.LENGTH_SHORT).show()
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
