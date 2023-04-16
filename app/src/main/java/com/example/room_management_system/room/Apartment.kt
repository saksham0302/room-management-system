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

    lateinit var v: View
    lateinit var apartments: RadioGroup
    lateinit var apartments1: RadioButton
    lateinit var apartments2: RadioButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_apartment, container, false)
        // Inflate the layout for this fragment
        apartments = v.findViewById(R.id.apartments)
        apartments1 = v.findViewById(R.id.apartments1)
        apartments2 = v.findViewById(R.id.apartments2)

        val roomsFragmentManager: FragmentManager = childFragmentManager
        var roomsFragmentTransaction = roomsFragmentManager.beginTransaction()
        roomsFragmentTransaction.commit()

        apartments.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            roomsFragmentTransaction = roomsFragmentManager.beginTransaction()
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
        while (i > 0) {
            roomsFragmentManager.popBackStack()
            i--
        }
        return v
    }
}