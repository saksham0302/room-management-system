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

class StandardAC : Fragment() {

    lateinit var v: View

    lateinit var standardAC: RadioGroup
    lateinit var standardAC1: RadioButton
    lateinit var standardAC2: RadioButton
    lateinit var standardAC3: RadioButton
    lateinit var standardAC4: RadioButton
    lateinit var standardAC5: RadioButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_standard_a_c, container, false)
        standardAC = v.findViewById(R.id.standardAC)
        standardAC1 = v.findViewById(R.id.standardAC1)
        standardAC2 = v.findViewById(R.id.standardAC2)
        standardAC3 = v.findViewById(R.id.standardAC3)
        standardAC4 = v.findViewById(R.id.standardAC4)
        standardAC5 = v.findViewById(R.id.standardAC5)

        val roomsFragmentManager: FragmentManager = childFragmentManager
        var roomsFragmentTransaction = roomsFragmentManager.beginTransaction()
        roomsFragmentTransaction.commit()

        standardAC.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            roomsFragmentTransaction = roomsFragmentManager.beginTransaction()
            when(checkedId) {
                R.id.standardAC1 -> {
                    roomsFragmentTransaction.replace(R.id.standardACRooms, Room())
                }
                R.id.standardAC2 -> {
                    roomsFragmentTransaction.replace(R.id.standardACRooms, Room())
                }
                R.id.standardAC3 -> {
                    roomsFragmentTransaction.replace(R.id.standardACRooms, Room())
                }
                R.id.standardAC4 -> {
                    roomsFragmentTransaction.replace(R.id.standardACRooms, Room())
                }
                R.id.standardAC5 -> {
                    roomsFragmentTransaction.replace(R.id.standardACRooms, Room())
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