package com.example.calculadora1

import android.graphics.Color
import android.os.Bundle
import android.os.Vibrator
import android.util.TypedValue
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadora1.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding
private var vibrator: Vibrator?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
vibrator= getSystemService(VIBRATOR_SERVICE) as Vibrator?
      var fontSizes= 60f
      var warningSizes: Float
        val calculo= binding.tvInput

      fun fontSizeDown(){
        if (binding.tvInput.text.length > 8
          && binding.tvInput.text.length < 11) {
          fontSizes -=5f
          binding.tvInput.setTextSize(TypedValue.COMPLEX_UNIT_DIP, fontSizes)
        }else{
          if (binding.tvInput.text.length >10){
            fontSizes =45f
            binding.tvInput.setTextSize(TypedValue.COMPLEX_UNIT_DIP, fontSizes)
          }else{
            fontSizes =60f
            binding.tvInput.setTextSize(TypedValue.COMPLEX_UNIT_DIP, fontSizes)
          }
        }
      }

      fun fontSizeUp(){
        if (binding.tvInput.text.length <13 && fontSizes <60){
          fontSizes +=5f
          binding.tvInput.setTextSize(TypedValue.COMPLEX_UNIT_DIP, fontSizes)
        }
      }



      binding.punt.setOnClickListener {
          vibrator?.vibrate(30)
          calculo.text = "${calculo.text}."
      }
      binding.cero.setOnClickListener {
        calculo.text= "${calculo.text}0"
        fontSizeDown()
          vibrator?.vibrate(30)
      }
      binding.uno.setOnClickListener {
            calculo.text= "${calculo.text}1"
        fontSizeDown()
          vibrator?.vibrate(30)
        }
      binding.dos.setOnClickListener {
        calculo.text= "${calculo.text}2"
        fontSizeDown()
          vibrator?.vibrate(30)
      }
      binding.tres.setOnClickListener {
        calculo.text= "${calculo.text}3"
        fontSizeDown()
          vibrator?.vibrate(30)
      }
      binding.cuat.setOnClickListener {
        calculo.text= "${calculo.text}4"
        fontSizeDown()
          vibrator?.vibrate(30)
      }
      binding.cinc.setOnClickListener {
        calculo.text= "${calculo.text}5"
        fontSizeDown()
          vibrator?.vibrate(30)
      }
      binding.seis.setOnClickListener {
        calculo.text= "${calculo.text}6"
        fontSizeDown()
          vibrator?.vibrate(30)
      }
      binding.siet.setOnClickListener {
        calculo.text= "${calculo.text}7"
        fontSizeDown()
          vibrator?.vibrate(30)
      }
      binding.ocho.setOnClickListener {
        calculo.text= "${calculo.text}8"
        fontSizeDown()
          vibrator?.vibrate(30)
      }
      binding.nuev.setOnClickListener {
        calculo.text= "${calculo.text}9"
        fontSizeDown()
          vibrator?.vibrate(30)
      }

      binding.pi.setOnClickListener {
        calculo.text= "${calculo.text}π"
          vibrator?.vibrate(30)
      }

      binding.perc.setOnClickListener {
        calculo.text= "${calculo.text}%"
          vibrator?.vibrate(30)
      }
      binding.raiz.setOnClickListener {
        calculo.text= "${calculo.text}√"
          vibrator?.vibrate(30)
      }
      binding.div.setOnClickListener {
        calculo.text= "${calculo.text}/"
          vibrator?.vibrate(30)
      }
      binding.mult.setOnClickListener {
        calculo.text= "${calculo.text}*"
          vibrator?.vibrate(30)
      }
      binding.rest.setOnClickListener {
        calculo.text= "${calculo.text}-"
          vibrator?.vibrate(30)
      }
      binding.suma.setOnClickListener {
        calculo.text= "${calculo.text}+"
          vibrator?.vibrate(30)
      }

      binding.para.setOnClickListener {
        calculo.text= "${calculo.text}("
          vibrator?.vibrate(30)
      }

      binding.parc.setOnClickListener {
        calculo.text= "${calculo.text})"
          vibrator?.vibrate(30)
      }

        binding.btnConv.setOnClickListener {
            calculo.text= "${calculo.text}7.2330138512099"
            vibrator?.vibrate(30)
        }

        binding.sign.setOnClickListener {
            calculo.text= "${calculo.text}*-1"
            vibrator?.vibrate(30)
        }

      binding.borr.setOnClickListener {
        calculo.text= calculo.text.dropLast(1)
        binding.tvOutput.text= ""
        fontSizeUp()
          vibrator?.vibrate(30)
      }
      binding.ce.setOnClickListener {
        calculo.text= ""
        
        binding.tvOutput.text=""
            fontSizes =60f
            binding.tvInput.setTextSize(TypedValue.COMPLEX_UNIT_DIP, fontSizes)
          vibrator?.vibrate(30)
      }

      binding.igua.setOnClickListener {
        val resultadoCalc= Expression(calculo.text.toString()).calculate()

        if (resultadoCalc.isNaN()){
          binding.tvOutput.text= "En serio?"
          warningSizes =20f
          binding.tvOutput.setTextSize(TypedValue.COMPLEX_UNIT_DIP, warningSizes)
          binding.tvOutput.setTextColor(Color.parseColor("#000000"))
            vibrator?.vibrate(30)
        }
        else{
          binding.tvInput.text= resultadoCalc.toString()
          fontSizeDown()
            vibrator?.vibrate(30)
        }
      }

    }
}