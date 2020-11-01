package com.hajarslamah.fragment_actavty

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.name_color.*
import java.util.*
import javax.security.auth.callback.Callback

class Name_color:Fragment() {
    interface Callbacks {
        fun onButtonClick(frag: String)    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?    }


    private var callbacks: Callbacks? = null
    override fun onDetach() {
        super.onDetach()
        callbacks = null    }
    companion object {
        fun newInstance(color:String): Name_color {
            val args = Bundle().apply {
                putSerializable("Name", color)
            }
            return Name_color().apply {
                arguments = args
            }
        }
    }
    var color: String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       color= arguments?.getSerializable("Name") as String

    }
    private lateinit var name: TextView
    private lateinit var btn: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?    ): View? {
        val view = inflater.inflate(R.layout.name_color, container, false)
        name = view.findViewById(R.id.name_text) as TextView
        btn = view.findViewById(R.id.btn_actvty) as Button
       name.setText(color)

        btn.setOnClickListener {
            callbacks?.onButtonClick("This is The Fragment1 in to Fragment2")

        }
        return view
    }
    }