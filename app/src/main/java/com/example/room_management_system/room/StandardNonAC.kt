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
import com.example.room_management_system.RoomReservation

class StandardNonAC : Fragment() {

    // Variable to access the layout widgets in fragment
    lateinit var v: View

    // Variables to access the widgets for choosing the standard non AC building
    lateinit var standardNonAC: RadioGroup
    lateinit var standardNonAC1: RadioButton
    lateinit var standardNonAC2: RadioButton
    lateinit var standardNonAC3: RadioButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Assigning inflater to the view variable
        v = inflater.inflate(R.layout.fragment_standard_non_a_c, container, false)

        // Referring the widgets
        standardNonAC = v.findViewById(R.id.standardNonAC)
        standardNonAC1 = v.findViewById(R.id.standardNonAC1)
        standardNonAC2 = v.findViewById(R.id.standardNonAC2)
        standardNonAC3 = v.findViewById(R.id.standardNonAC3)

        // Fragment Manager to call the fragments
        val roomsFragmentManager: FragmentManager = childFragmentManager
        var roomsFragmentTransaction = roomsFragmentManager.beginTransaction()
        roomsFragmentTransaction.commit()

        // Perform action after a radio button is clicked
        standardNonAC.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->

            roomsFragmentTransaction = roomsFragmentManager.beginTransaction()

            // send standard non ac rooms to main
            val mai = activity as RoomReservation

            // Check the value of radio button clicked and later redirect to the decided fragment
            when(checkedId) {
                R.id.standardNonAC1 -> {
                    mai.roomType("BH 6")
                    roomsFragmentTransaction.replace(R.id.standardNonACRooms, Room())
                }
                R.id.standardNonAC2 -> {
                    mai.roomType("BH 7")
                    roomsFragmentTransaction.replace(R.id.standardNonACRooms, Room())
                }
                R.id.standardNonAC3 -> {
                    mai.roomType("BH 8")
                    roomsFragmentTransaction.replace(R.id.standardNonACRooms, Room())
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