package com.hajarslamah.fragment_actavty

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class frag_color :Fragment() {
    var color: String=""
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
        fun newInstance(color:String): frag_color {
            val args = Bundle().apply {
                putSerializable("Name", color)
            }
            return frag_color().apply {
                arguments = args
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        color= arguments?.getSerializable("Name") as String

    }

    private lateinit var name: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?    ): View? {
        val view = inflater.inflate(R.layout.name2_color, container, false)
        name = view.findViewById(R.id.name_text_frag2) as TextView
        name.text=color
        return view
    }
}
