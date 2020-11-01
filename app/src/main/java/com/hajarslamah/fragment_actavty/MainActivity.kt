package com.hajarslamah.fragment_actavty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(),Name_color.Callbacks,frag_color.Callbacks {
    lateinit var red:Button
    lateinit var green:Button
    lateinit var blue:Button
    lateinit var fragText:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
  red=findViewById(R.id.name_1)
        green=findViewById(R.id.name_2)
        blue=findViewById(R.id.name_3)
        fragText=findViewById(R.id.text_activity)

        red.setOnClickListener {
            sendColor("red")
        }

        green.setOnClickListener {
            sendColor("green")
        }

        blue.setOnClickListener {
            sendColor("blue")
        }

    }

    fun sendColor(color:String){
        val currentFragment=supportFragmentManager.findFragmentById(R.id.frame)
        if(currentFragment==null){
            val fragment =Name_color.newInstance(color)
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame,fragment)
                .addToBackStack(null)
                .commit()

        }

    }

    override fun onButtonClick(frag: String) {
//fragText.setText(frag)
 val currentFragment=supportFragmentManager.findFragmentById(R.id.frame2)
        if(currentFragment==null){
            val fragment =frag_color.newInstance(frag)
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame2,fragment)
               .addToBackStack(null)
                .commit()

        }

    }



}