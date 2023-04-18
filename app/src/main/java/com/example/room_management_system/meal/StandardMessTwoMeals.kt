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

class StandardMessTwoMeals : Fragment() {

    // Variable to access the layout widgets in fragment
    lateinit var v: View

    // Variables to access the widgets for choosing the mess
    lateinit var standardTwoMeals: RadioGroup
    lateinit var standardTwoMeals1: RadioButton
    lateinit var standardTwoMeals2: RadioButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Assigning inflater to the view variable
        v = inflater.inflate(R.layout.fragment_standard_mess_two_meals, container, false)

        // Referring the widgets
        standardTwoMeals = v.findViewById(R.id.standardTwoMeals)
        standardTwoMeals1 = v.findViewById(R.id.standardTwoMeals1)
        standardTwoMeals2 = v.findViewById(R.id.standardTwoMeals2)

        // Fragment Manager to call the fragments
        val mealsFragmentManager: FragmentManager = childFragmentManager
        var mealsFragmentTransaction = mealsFragmentManager.beginTransaction()
        mealsFragmentTransaction.commit()

        // Perform action after a radio button is clicked
        standardTwoMeals.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->

            mealsFragmentTransaction = mealsFragmentManager.beginTransaction()

            // Send the standard two meals location to main
            val mai = activity as RoomReservation

            // Check the value of radio button clicked and later redirect to the decided fragment
            when(checkedId) {
                R.id.standardTwoMeals1 -> {
                    mai.messLocation("Hostel Mess")
                    mealsFragmentTransaction.replace(R.id.messTwoMeals, Meal())
                }
                R.id.standardTwoMeals2 -> {
                    mai.messLocation("Centralized Mess-2")
                    mealsFragmentTransaction.replace(R.id.messTwoMeals, Meal())
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