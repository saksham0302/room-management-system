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
import com.example.room_management_system.RoomReservation
import com.example.room_management_system.room.Room

class Alacarte : Fragment() {

    // Variable to access the layout widgets in fragment
    lateinit var v: View

    // Variables to access the widgets for choosing the mess
    lateinit var alacarte: RadioGroup
    lateinit var alacarte1: RadioButton
    lateinit var alacarte2: RadioButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Assigning inflater to the view variable
        v = inflater.inflate(R.layout.fragment_alacarte, container, false)

        // Referring the widgets
        alacarte = v.findViewById(R.id.alacarte)
        alacarte1 = v.findViewById(R.id.alacarte1)
        alacarte2 = v.findViewById(R.id.alacarte2)

        // Send the alacarte location to main
        val mai = activity as RoomReservation

        // Perform action after a radio button is clicked
        alacarte.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->

            // Check the value of radio button clicked and perform the necessary action
            when(checkedId) {
                R.id.apartments1 -> { mai.messLocation("Apartment Mess") }
                R.id.apartments2 -> { mai.messLocation("Centralized Mess-1") }
            }

        })

        // Inflate the layout for this fragment
        return v
    }
}