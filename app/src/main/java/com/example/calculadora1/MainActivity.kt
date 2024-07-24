package com.example.calculadora1

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadora1.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

      var fontSizes= 70f
      var warningSizes= 40f
      val calculo= binding.tvinput

      fun fontSizeDown(){
        if (binding.tvinput.text.length > 8
          && binding.tvinput.text.length < 11) {
          fontSizes -=5f
          binding.tvinput.setTextSize(TypedValue.COMPLEX_UNIT_DIP, fontSizes)
        }else{
          if (binding.tvinput.text.length >10){
            fontSizes =45f
            binding.tvinput.setTextSize(TypedValue.COMPLEX_UNIT_DIP, fontSizes)
          }else{
            fontSizes =70f
            binding.tvinput.setTextSize(TypedValue.COMPLEX_UNIT_DIP, fontSizes)
          }
        }
      }

      fun fontSizeUp(){
        if (binding.tvinput.text.length <13 && fontSizes <65){
          fontSizes +=5f
          binding.tvinput.setTextSize(TypedValue.COMPLEX_UNIT_DIP, fontSizes)
        }
      }

      binding.punt.setOnClickListener {

          calculo.text = "${calculo.text}."
      }
      binding.cero.setOnClickListener {
        calculo.text= "${calculo.text}0"
        fontSizeDown()
      }
      binding.uno.setOnClickListener {
            calculo.text= "${calculo.text}1"
        fontSizeDown()
        }
      binding.dos.setOnClickListener {
        calculo.text= "${calculo.text}2"
        fontSizeDown()
      }
      binding.tres.setOnClickListener {
        calculo.text= "${calculo.text}3"
        fontSizeDown()
      }
      binding.cuat.setOnClickListener {
        calculo.text= "${calculo.text}4"
        fontSizeDown()
      }
      binding.cinc.setOnClickListener {
        calculo.text= "${calculo.text}5"
        fontSizeDown()
      }
      binding.seis.setOnClickListener {
        calculo.text= "${calculo.text}6"
        fontSizeDown()
      }
      binding.siet.setOnClickListener {
        calculo.text= "${calculo.text}7"
        fontSizeDown()
      }
      binding.ocho.setOnClickListener {
        calculo.text= "${calculo.text}8"
        fontSizeDown()
      }
      binding.nuev.setOnClickListener {
        calculo.text= "${calculo.text}9"
        fontSizeDown()
      }

      binding.perc.setOnClickListener {
        calculo.text= "${calculo.text}%"
      }
      binding.raiz.setOnClickListener {
        calculo.text= "${calculo.text}√"
      }
      binding.div.setOnClickListener {
        calculo.text= "${calculo.text}/"
      }
      binding.mult.setOnClickListener {
        calculo.text= "${calculo.text}*"
      }
      binding.rest.setOnClickListener {
        calculo.text= "${calculo.text}-"
      }
      binding.suma.setOnClickListener {
        calculo.text= "${calculo.text}+"
      }


      binding.borr.setOnClickListener {
        calculo.text= calculo.text.dropLast(1)
        binding.tvOutput.text= ""
        fontSizeUp()
      }
      binding.ce.setOnClickListener {
        calculo.text= ""
        binding.tvOutput.text= ""
            fontSizes =60f
            binding.tvinput.setTextSize(TypedValue.COMPLEX_UNIT_DIP, fontSizes)
      }

      binding.igua.setOnClickListener {
        val resultadoCalc= Expression(calculo.text.toString()).calculate()

        if (resultadoCalc.isNaN()){
          binding.tvOutput.text= "AHORA VEO POR QUE NECESITAS UNA CALCULADORA!"
          warningSizes =20f
          binding.tvOutput.setTextSize(TypedValue.COMPLEX_UNIT_DIP, warningSizes)
          binding.tvOutput.setTextColor(Color.parseColor("#FF0000"))
        }
        else{
          binding.tvinput.text= resultadoCalc.toString()
          fontSizeDown()
        }
      }

    }
}