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

class StandardMessTwoMeals : Fragment() {

    lateinit var v: View
    lateinit var standardTwoMeals: RadioGroup
    lateinit var standardTwoMeals1: RadioButton
    lateinit var standardTwoMeals2: RadioButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_standard_mess_two_meals, container, false)
        standardTwoMeals = v.findViewById(R.id.standardTwoMeals)
        standardTwoMeals1 = v.findViewById(R.id.standardTwoMeals1)
        standardTwoMeals2 = v.findViewById(R.id.standardTwoMeals2)

        val mealsFragmentManager: FragmentManager = childFragmentManager
        var mealsFragmentTransaction = mealsFragmentManager.beginTransaction()
        mealsFragmentTransaction.commit()

        standardTwoMeals.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            mealsFragmentTransaction = mealsFragmentManager.beginTransaction()
            when(checkedId) {
                R.id.standardTwoMeals1 -> {
                    mealsFragmentTransaction.replace(R.id.messTwoMeals, Meal())
                }
                R.id.standardTwoMeals2 -> {
                    mealsFragmentTransaction.replace(R.id.messTwoMeals, Meal())
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