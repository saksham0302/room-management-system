package com.example.room_management_system

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.FragmentManager
import com.example.room_management_system.meal.Alacarte
import com.example.room_management_system.meal.StandardMessFourMeals
import com.example.room_management_system.meal.StandardMessTwoMeals
import com.example.room_management_system.room.Apartment
import com.example.room_management_system.room.StandardAC
import com.example.room_management_system.room.StandardNonAC

class HomeScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        selectRoom()
        selectMeal()
    }

    lateinit var room: RadioGroup
    lateinit var room1: RadioButton
    lateinit var room2: RadioButton
    lateinit var room3: RadioButton

    fun selectRoom() {
        room = findViewById(R.id.room)
        room1 = findViewById(R.id.room1)
        room2 = findViewById(R.id.room2)
        room3 = findViewById(R.id.room3)

        val mealFragmentManager: FragmentManager = supportFragmentManager
        var roomFragmentTransaction = mealFragmentManager.beginTransaction()
        roomFragmentTransaction.commit()

        room.setOnCheckedChangeListener (RadioGroup.OnCheckedChangeListener { radioGroup, checkedId ->
            roomFragmentTransaction = mealFragmentManager.beginTransaction()
            when (checkedId) {
                R.id.room1 -> {
                    roomFragmentTransaction.replace(R.id.roomFrameLayout, Apartment())
                }
                R.id.room2 -> {
                    roomFragmentTransaction.replace(R.id.roomFrameLayout, StandardAC())
                }
                R.id.room3 -> {
                    roomFragmentTransaction.replace(R.id.roomFrameLayout, StandardNonAC())
                }
            }
            roomFragmentTransaction.commit()
        })
        var i = mealFragmentManager.backStackEntryCount
        while (i > 0) {
            mealFragmentManager.popBackStack()
            i--
        }
    }

    lateinit var meal: RadioGroup
    lateinit var meal1: RadioButton
    lateinit var meal2: RadioButton
    lateinit var meal3: RadioButton

    fun selectMeal() {
        meal = findViewById(R.id.meal)
        meal1 = findViewById(R.id.meal1)
        meal2 = findViewById(R.id.meal2)
        meal3 = findViewById(R.id.meal3)

        val mealFragmentManager: FragmentManager = supportFragmentManager
        var mealFragmentTransaction = mealFragmentManager.beginTransaction()
        mealFragmentTransaction.commit()

        meal.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, checkedId ->
            mealFragmentTransaction = mealFragmentManager.beginTransaction()
            when (checkedId) {
                R.id.meal1 -> {
                    mealFragmentTransaction.replace(R.id.mealFrameLayout, Alacarte())
                }
                R.id.meal2 -> {
                    mealFragmentTransaction.replace(R.id.mealFrameLayout, StandardMessFourMeals())
                }
                R.id.meal3 -> {
                    mealFragmentTransaction.replace(R.id.mealFrameLayout, StandardMessTwoMeals())
                }
            }
            mealFragmentTransaction.commit()
        })
        var i = mealFragmentManager.backStackEntryCount
        while (i > 0) {
            mealFragmentManager.popBackStack()
            i--
        }
    }
}