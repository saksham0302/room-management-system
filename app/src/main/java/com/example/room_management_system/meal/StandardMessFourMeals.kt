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
import com.example.room_management_system.room.Room

class StandardMessFourMeals : Fragment() {

    lateinit var v: View
    lateinit var standardFourMeals: RadioGroup
    lateinit var standardFourMeals1: RadioButton
    lateinit var standardFourMeals2: RadioButton
    lateinit var standardFourMeals3: RadioButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_standard_mess_four_meals, container, false)
        standardFourMeals = v.findViewById(R.id.standardFourMeals)
        standardFourMeals1 = v.findViewById(R.id.standardFourMeals1)
        standardFourMeals2 = v.findViewById(R.id.standardFourMeals2)
        standardFourMeals3 = v.findViewById(R.id.standardFourMeals3)

        val mealsFragmentManager: FragmentManager = childFragmentManager
        var mealsFragmentTransaction = mealsFragmentManager.beginTransaction()
        mealsFragmentTransaction.commit()

        standardFourMeals.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            mealsFragmentTransaction = mealsFragmentManager.beginTransaction()
            when(checkedId) {
                R.id.standardFourMeals1 -> {
                    mealsFragmentTransaction.replace(R.id.messFourMeals, Meal())
                }
                R.id.standardFourMeals2 -> {
                    mealsFragmentTransaction.replace(R.id.messFourMeals, Meal())
                }
                R.id.standardFourMeals3 -> {
                    mealsFragmentTransaction.replace(R.id.messFourMeals, Meal())
                }
            }
            mealsFragmentTransaction.commit()
        })
        var i = mealsFragmentManager.backStackEntryCount
        while (i > 0) {
            mealsFragmentManager.popBackStack()
            i--
        }
        return v
    }
}