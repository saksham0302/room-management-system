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

    lateinit var roomType: RadioGroup
    lateinit var roomType1: RadioButton
    lateinit var roomType2: RadioButton
    lateinit var roomType3: RadioButton

    fun selectRoom() {
        roomType = findViewById(R.id.roomType)
        roomType1 = findViewById(R.id.roomType1)
        roomType2 = findViewById(R.id.roomType2)
        roomType3 = findViewById(R.id.roomType3)

        val roomFragmentManager: FragmentManager = supportFragmentManager
        var roomFragmentTransaction = roomFragmentManager.beginTransaction()
        roomFragmentTransaction.commit()

        roomType.setOnCheckedChangeListener (RadioGroup.OnCheckedChangeListener { radioGroup, checkedId ->
            roomFragmentTransaction = roomFragmentManager.beginTransaction()
            when (checkedId) {
                R.id.roomType1 -> {
                    roomFragmentTransaction.replace(R.id.roomTypeFrameLayout, Apartment())
                }
                R.id.roomType2 -> {
                    roomFragmentTransaction.replace(R.id.roomTypeFrameLayout, StandardAC())
                }
                R.id.roomType3 -> {
                    roomFragmentTransaction.replace(R.id.roomTypeFrameLayout, StandardNonAC())
                }
            }
            roomFragmentTransaction.commit()
        })
        var i = roomFragmentManager.backStackEntryCount
        while (i > 0) {
            roomFragmentManager.popBackStack()
            i--
        }
    }


    lateinit var mealType: RadioGroup
    lateinit var mealType1: RadioButton
    lateinit var mealType2: RadioButton
    lateinit var mealType3: RadioButton

    fun selectMeal() {
        mealType = findViewById(R.id.mealType)
        mealType1 = findViewById(R.id.mealType1)
        mealType2 = findViewById(R.id.mealType2)
        mealType3 = findViewById(R.id.mealType3)

        val mealFragmentManager: FragmentManager = supportFragmentManager
        var mealFragmentTransaction = mealFragmentManager.beginTransaction()
        mealFragmentTransaction.commit()

        mealType.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, checkedId ->
            mealFragmentTransaction = mealFragmentManager.beginTransaction()
            when (checkedId) {
                R.id.mealType1 -> {
                    mealFragmentTransaction.replace(R.id.mealTypeFrameLayout, Alacarte())
                }
                R.id.mealType2 -> {
                    mealFragmentTransaction.replace(R.id.mealTypeFrameLayout, StandardMessFourMeals())
                }
                R.id.mealType3 -> {
                    mealFragmentTransaction.replace(R.id.mealTypeFrameLayout, StandardMessTwoMeals())
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