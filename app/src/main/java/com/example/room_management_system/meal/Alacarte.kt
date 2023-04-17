package com.example.room_management_system.meal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.FragmentManager
import com.example.room_management_system.R
import com.example.room_management_system.room.Room

class Alacarte : Fragment() {

    lateinit var v: View
    lateinit var alacarte: RadioGroup
    lateinit var alacarte1: RadioButton
    lateinit var alacarte2: RadioButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_alacarte, container, false)
        alacarte = v.findViewById(R.id.alacarte)
        alacarte1 = v.findViewById(R.id.alacarte1)
        alacarte2 = v.findViewById(R.id.alacarte2)

        alacarte.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            when(checkedId) {
                R.id.apartments1 -> {  }
                R.id.apartments2 -> {  }
            }
        })
        // Inflate the layout for this fragment
        return v
    }
}