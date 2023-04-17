package com.example.room_management_system.meal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.room_management_system.R

class Meal : Fragment() {

    lateinit var v: View
    lateinit var meal: RadioGroup
    lateinit var meal1: RadioButton
    lateinit var meal2: RadioButton
    lateinit var meal3: RadioButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_meal, container, false)
        meal = v.findViewById(R.id.meal)
        meal1 = v.findViewById(R.id.meal1)
        meal2 = v.findViewById(R.id.meal2)
        meal3 = v.findViewById(R.id.meal3)

        meal.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, checkedId ->

            when(checkedId) {
                R.id.meal1 -> {}
                R.id.meal2 -> {}
                R.id.meal3 -> {}
            }
        })

        // Inflate the layout for this fragment
        return v
    }
}