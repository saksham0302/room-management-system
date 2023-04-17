package com.example.room_management_system

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.FragmentManager
import com.example.room_management_system.meal.Alacarte
import com.example.room_management_system.meal.StandardMessFourMeals
import com.example.room_management_system.meal.StandardMessTwoMeals
import com.example.room_management_system.room.Apartment
import com.example.room_management_system.room.StandardAC
import com.example.room_management_system.room.StandardNonAC

class RoomReservation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_reservation)

        // Function to apply the working of room reserving
        selectRoom()

        // Function to apply the booking of mess
        selectMeal()
    }


    // Variables to access the widgets for reserving room type
    lateinit var roomType: RadioGroup
    lateinit var roomType1: RadioButton
    lateinit var roomType2: RadioButton
    lateinit var roomType3: RadioButton

    fun selectRoom() {

        // Referring the widgets
        roomType = findViewById(R.id.roomType)
        roomType1 = findViewById(R.id.roomType1)
        roomType2 = findViewById(R.id.roomType2)
        roomType3 = findViewById(R.id.roomType3)

        // Fragment Manager to call the fragments
        val roomFragmentManager: FragmentManager = supportFragmentManager
        var roomFragmentTransaction = roomFragmentManager.beginTransaction()
        roomFragmentTransaction.commit()

        // Perform action after a radio button is clicked
        roomType.setOnCheckedChangeListener (RadioGroup.OnCheckedChangeListener { radioGroup, checkedId ->

            roomFragmentTransaction = roomFragmentManager.beginTransaction()

            // Check the value of radio button clicked and later redirect to the decided fragment
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
        // Empty the stack of fragment manager
        while (i > 0) {
            roomFragmentManager.popBackStack()
            i--
        }
    }


    // Variables to access the widgets for choosing the mess type
    lateinit var mealType: RadioGroup
    lateinit var mealType1: RadioButton
    lateinit var mealType2: RadioButton
    lateinit var mealType3: RadioButton

    fun selectMeal() {

        // Referring the widgets
        mealType = findViewById(R.id.mealType)
        mealType1 = findViewById(R.id.mealType1)
        mealType2 = findViewById(R.id.mealType2)
        mealType3 = findViewById(R.id.mealType3)

        // Fragment Manager to call the fragments
        val mealFragmentManager: FragmentManager = supportFragmentManager
        var mealFragmentTransaction = mealFragmentManager.beginTransaction()
        mealFragmentTransaction.commit()

        // Perform action after a radio button is clicked
        mealType.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, checkedId ->

            mealFragmentTransaction = mealFragmentManager.beginTransaction()

            // Check the value of radio button clicked and later redirect to the decided fragment
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
        // Empty the stack of fragment manager
        while (i > 0) {
            mealFragmentManager.popBackStack()
            i--
        }
    }


    // Variables to access the widgets for choosing other facilities
    lateinit var gym: CheckBox
    lateinit var laundry: CheckBox
}