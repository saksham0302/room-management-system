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

class StandardAC : Fragment() {

    // Variable to access the layout widgets in fragment
    lateinit var v: View

    // Variables to access the widgets for choosing the standard AC building
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

        // Assigning inflater to the view variable
        v = inflater.inflate(R.layout.fragment_standard_a_c, container, false)

        // Referring the widgets
        standardAC = v.findViewById(R.id.standardAC)
        standardAC1 = v.findViewById(R.id.standardAC1)
        standardAC2 = v.findViewById(R.id.standardAC2)
        standardAC3 = v.findViewById(R.id.standardAC3)
        standardAC4 = v.findViewById(R.id.standardAC4)
        standardAC5 = v.findViewById(R.id.standardAC5)

        // Fragment Manager to call the fragments
        val roomsFragmentManager: FragmentManager = childFragmentManager

        var roomsFragmentTransaction = roomsFragmentManager.beginTransaction()
        roomsFragmentTransaction.commit()

        // Perform action after a radio button is clicked
        standardAC.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->

            roomsFragmentTransaction = roomsFragmentManager.beginTransaction()

            // Send the standard ac rooms to main
            val mai = activity as RoomReservation

            // Check the value of radio button clicked and later redirect to the decided fragment
            when(checkedId) {
                R.id.standardAC1 -> {
                    mai.roomType("BH 1")
                    roomsFragmentTransaction.replace(R.id.standardACRooms, Room())
                }
                R.id.standardAC2 -> {
                    mai.roomType("BH 2")
                    roomsFragmentTransaction.replace(R.id.standardACRooms, Room())
                }
                R.id.standardAC3 -> {
                    mai.roomType("BH 3")
                    roomsFragmentTransaction.replace(R.id.standardACRooms, Room())
                }
                R.id.standardAC4 -> {
                    mai.roomType("BH 4")
                    roomsFragmentTransaction.replace(R.id.standardACRooms, Room())
                }
                R.id.standardAC5 -> {
                    mai.roomType("BH 5")
                    roomsFragmentTransaction.replace(R.id.standardACRooms, Room())
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