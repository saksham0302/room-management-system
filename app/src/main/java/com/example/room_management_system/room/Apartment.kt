package com.example.room_management_system.room

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.FragmentManager
import com.example.room_management_system.R

class Apartment : Fragment() {

    // Variable to access the layout widgets in fragment
    lateinit var v: View

    // Variables to access the widgets for choosing the apartment building
    lateinit var apartments: RadioGroup
    lateinit var apartments1: RadioButton
    lateinit var apartments2: RadioButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Assigning inflater to the view variable
        v = inflater.inflate(R.layout.fragment_apartment, container, false)

        // Referring the widgets
        apartments = v.findViewById(R.id.apartments)
        apartments1 = v.findViewById(R.id.apartments1)
        apartments2 = v.findViewById(R.id.apartments2)

        // Fragment Manager to call the fragments
        val roomsFragmentManager: FragmentManager = childFragmentManager
        var roomsFragmentTransaction = roomsFragmentManager.beginTransaction()
        roomsFragmentTransaction.commit()

        // Perform action after a radio button is clicked
        apartments.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->

            roomsFragmentTransaction = roomsFragmentManager.beginTransaction()

            // Check the value of radio button clicked and later redirect to the decided fragment
            when(checkedId) {
                R.id.apartments1 -> {
                    roomsFragmentTransaction.replace(R.id.apartmentRooms, Room())
                }
                R.id.apartments2 -> {
                    roomsFragmentTransaction.replace(R.id.apartmentRooms, Room())
                }
            }

            roomsFragmentTransaction.commit()
        })

        var i = roomsFragmentManager.backStackEntryCount
        // Empty the stack of fragment manager
        while (i > 0) {
            roomsFragmentManager.popBackStack()
            i--
        }

        // Inflate the layout for this fragment
        return v
    }
}