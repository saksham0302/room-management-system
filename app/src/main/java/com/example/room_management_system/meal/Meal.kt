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

    // Variable to access the layout widgets in fragment
    lateinit var v: View

    // Variables to access the widgets for choosing the menu choice
    lateinit var meal: RadioGroup
    lateinit var meal1: RadioButton
    lateinit var meal2: RadioButton
    lateinit var meal3: RadioButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Assigning inflater to the view variable
        v = inflater.inflate(R.layout.fragment_meal, container, false)

        // Referring the widgets
        meal = v.findViewById(R.id.meal)
        meal1 = v.findViewById(R.id.meal1)
        meal2 = v.findViewById(R.id.meal2)
        meal3 = v.findViewById(R.id.meal3)

        // Perform action after a radio button is clicked
        meal.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, checkedId ->

            // Check the value of radio button clicked and later redirect to the decided fragment
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