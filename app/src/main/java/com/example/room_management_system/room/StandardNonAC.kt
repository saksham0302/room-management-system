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

class StandardNonAC : Fragment() {

    lateinit var v: View

    lateinit var standardNonAC: RadioGroup
    lateinit var standardNonAC1: RadioButton
    lateinit var standardNonAC2: RadioButton
    lateinit var standardNonAC3: RadioButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_standard_non_a_c, container, false)
        standardNonAC = v.findViewById(R.id.standardNonAC)
        standardNonAC1 = v.findViewById(R.id.standardNonAC1)
        standardNonAC2 = v.findViewById(R.id.standardNonAC2)
        standardNonAC3 = v.findViewById(R.id.standardNonAC3)

        val roomsFragmentManager: FragmentManager = childFragmentManager
        var roomsFragmentTransaction = roomsFragmentManager.beginTransaction()
        roomsFragmentTransaction.commit()

        standardNonAC.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            roomsFragmentTransaction = roomsFragmentManager.beginTransaction()
            when(checkedId) {
                R.id.standardNonAC1 -> {
                    roomsFragmentTransaction.replace(R.id.standardNonACRooms, Room())
                }
                R.id.standardNonAC2 -> {
                    roomsFragmentTransaction.replace(R.id.standardNonACRooms, Room())
                }
                R.id.standardNonAC3 -> {
                    roomsFragmentTransaction.replace(R.id.standardNonACRooms, Room())
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