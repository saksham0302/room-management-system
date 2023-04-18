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

class StandardMessFourMeals : Fragment() {

    // Variable to access the layout widgets in fragment
    lateinit var v: View

    // Variables to access the widgets for choosing the mess
    lateinit var standardFourMeals: RadioGroup
    lateinit var standardFourMeals1: RadioButton
    lateinit var standardFourMeals2: RadioButton
    lateinit var standardFourMeals3: RadioButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Assigning inflater to the view variable
        v = inflater.inflate(R.layout.fragment_standard_mess_four_meals, container, false)

        // Referring the widgets
        standardFourMeals = v.findViewById(R.id.standardFourMeals)
        standardFourMeals1 = v.findViewById(R.id.standardFourMeals1)
        standardFourMeals2 = v.findViewById(R.id.standardFourMeals2)
        standardFourMeals3 = v.findViewById(R.id.standardFourMeals3)

        // Fragment Manager to call the fragments
        val mealsFragmentManager: FragmentManager = childFragmentManager
        var mealsFragmentTransaction = mealsFragmentManager.beginTransaction()
        mealsFragmentTransaction.commit()

        // Perform action after a radio button is clicked
        standardFourMeals.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->

            mealsFragmentTransaction = mealsFragmentManager.beginTransaction()

            // Send the standard four meals location to main
            val mai = activity as RoomReservation

            // Check the value of radio button clicked and later redirect to the decided fragment
            when(checkedId) {
                R.id.standardFourMeals1 -> {
                    mai.messLocation("Hostel Mess")
                    mealsFragmentTransaction.replace(R.id.messFourMeals, Meal())
                }
                R.id.standardFourMeals2 -> {
                    mai.messLocation("Centralized Mess-1")
                    mealsFragmentTransaction.replace(R.id.messFourMeals, Meal())
                }
                R.id.standardFourMeals3 -> {
                    mai.messLocation("Centralized Mess-2")
                    mealsFragmentTransaction.replace(R.id.messFourMeals, Meal())
                }
            }

            mealsFragmentTransaction.commit()
        })

        var i = mealsFragmentManager.backStackEntryCount
        // Empty the stack of fragment manager
        while (i > 0) {
            mealsFragmentManager.popBackStack()
            i--
        }

        // Inflate the layout for this fragment
        return v
    }
}