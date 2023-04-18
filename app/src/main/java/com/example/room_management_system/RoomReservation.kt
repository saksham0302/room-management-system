package com.example.room_management_system

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
//import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.FragmentManager
import com.example.room_management_system.meal.Alacarte
import com.example.room_management_system.meal.StandardMessFourMeals
import com.example.room_management_system.meal.StandardMessTwoMeals
import com.example.room_management_system.room.Apartment
import com.example.room_management_system.room.StandardAC
import com.example.room_management_system.room.StandardNonAC

class RoomReservation : AppCompatActivity(), ShareDetails {

    private lateinit var sharedPrefs: SharedPreferences
    private val file = "DetailsFile"
    private val residentialFacility = "ResidentialFacility"
    private val residentialCharges = "ResidentialCharges"
    private val residentialBlock = "ResidentialBlock"
    private val floorNo = "FloorNo"
    private val roomNo = "RoomNo"
    private val mess = "MessType"
    private val messCharges = "MessCharges"
    private val messLocation = "MessLocation"
    private val messMenu = "MessMenu"
    private val gymFacility = "Gym"
    private val gymFacilityCharges = "GymCharges"
    private val laundryFacility = "laundry"
    private val laundryFacilityCharges = "laundryCharges"

    // To see whether room is selected or not
    private var roomSelected: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_reservation)

        sharedPrefs = getSharedPreferences(file, Context.MODE_PRIVATE)
        sharedPrefs.edit().clear().apply()

        // Function to apply the working of room reserving
        selectRoom()

        // Function to apply the booking of mess
        selectMeal()

        // Function to apply the booking of other facilities
        selectOtherFacilities()

        // Condition for choosing apartments and redirecting to details page
        bookNow()
    }

    // Variables to access the widgets for reserving room type
    private lateinit var roomType: RadioGroup
    private lateinit var roomType1: RadioButton
    private lateinit var roomType2: RadioButton
    private lateinit var roomType3: RadioButton

    private fun selectRoom() {

        // Referring the widgets
        roomType = findViewById(R.id.roomType)
        roomType1 = findViewById(R.id.roomType1)
        roomType2 = findViewById(R.id.roomType2)
        roomType3 = findViewById(R.id.roomType3)

        // Fragment Manager to call the fragments
        val roomFragmentManager: FragmentManager = supportFragmentManager
        var roomFragmentTransaction = roomFragmentManager.beginTransaction()
        roomFragmentTransaction.commit()

        // shared pref to assign data in new activity
        val assign = sharedPrefs.edit()

        // Perform action after a radio button is clicked
        roomType.setOnCheckedChangeListener { _, checkedId ->

            roomFragmentTransaction = roomFragmentManager.beginTransaction()

            // Check the value of radio button clicked and later redirect to the decided fragment
            when (checkedId) {
                R.id.roomType1 -> {
                    assign.putString(residentialFacility, "Apartments")
                    assign.putFloat(residentialCharges, 120000.00F)
                    roomFragmentTransaction.replace(R.id.roomTypeFrameLayout, Apartment())
                    roomSelected = true
                    assign.apply()
                }
                R.id.roomType2 -> {
                    assign.putString(residentialFacility, "Standard AC")
                    assign.putFloat(residentialCharges, 105000.00F)
                    roomFragmentTransaction.replace(R.id.roomTypeFrameLayout, StandardAC())
                    roomSelected = true
                    assign.apply()
                }
                R.id.roomType3 -> {
                    assign.putString(residentialFacility, "Standard Non AC")
                    assign.putFloat(residentialCharges, 90000.00F)
                    roomFragmentTransaction.replace(R.id.roomTypeFrameLayout, StandardNonAC())
                    roomSelected = true
                    assign.apply()
                }
            }

            roomFragmentTransaction.commit()
        }

        var i = roomFragmentManager.backStackEntryCount
        // Empty the stack of fragment manager
        while (i > 0) {
            roomFragmentManager.popBackStack()
            i--
        }
    }


    // Variables to access the widgets for choosing the mess type
    private lateinit var mealType: RadioGroup
    private lateinit var mealType1: RadioButton
    private lateinit var mealType2: RadioButton
    private lateinit var mealType3: RadioButton

    private fun selectMeal() {

        // Referring the widgets
        mealType = findViewById(R.id.mealType)
        mealType1 = findViewById(R.id.mealType1)
        mealType2 = findViewById(R.id.mealType2)
        mealType3 = findViewById(R.id.mealType3)

        // Fragment Manager to call the fragments
        val mealFragmentManager: FragmentManager = supportFragmentManager
        var mealFragmentTransaction = mealFragmentManager.beginTransaction()
        mealFragmentTransaction.commit()

        // shared pref to retrieve data in new activity
        val assign = sharedPrefs.edit()

        // Perform action after a radio button is clicked
        mealType.setOnCheckedChangeListener { _, checkedId ->

            mealFragmentTransaction = mealFragmentManager.beginTransaction()

            // Check the value of radio button clicked and later redirect to the decided fragment
            when (checkedId) {
                R.id.mealType1 -> {
                    assign.putString(mess, "Alacarte")
                    assign.putFloat(messCharges, 50000.00F)
                    mealFragmentTransaction.replace(R.id.mealTypeFrameLayout, Alacarte())
                    assign.apply()
                }
                R.id.mealType2 -> {
                    assign.putString(mess, "Standard Mess Four Meals")
                    assign.putFloat(messCharges, 40000.00F)
                    mealFragmentTransaction.replace(
                        R.id.mealTypeFrameLayout,
                        StandardMessFourMeals()
                    )
                    assign.apply()
                }
                R.id.mealType3 -> {
                    assign.putString(mess, "Standard Mess Two Meals")
                    assign.putFloat(messCharges, 30000.00F)
                    mealFragmentTransaction.replace(
                        R.id.mealTypeFrameLayout,
                        StandardMessTwoMeals()
                    )
                    assign.apply()
                }
            }

            mealFragmentTransaction.commit()
        }

        var i = mealFragmentManager.backStackEntryCount
        // Empty the stack of fragment manager
        while (i > 0) {
            mealFragmentManager.popBackStack()
            i--
        }
    }


    // Variables to access the widgets for choosing other facilities
    private lateinit var gym: CheckBox
    private lateinit var laundry: CheckBox

    private fun selectOtherFacilities() {
        gym = findViewById(R.id.gym)
        laundry = findViewById(R.id.laundry)

        // shared pref to assign data in new activity
        val assign = sharedPrefs.edit()

        gym.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener {buttonView, isChecked ->
            if (isChecked) {
                assign.putString(gymFacility, "Opted")
                assign.putFloat(gymFacilityCharges, 4000.00F)
                assign.apply()
            }
        })

        laundry.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener {buttonView, isChecked ->
            if (isChecked) {
                assign.putString(laundryFacility, "Opted")
                assign.putFloat(laundryFacilityCharges, 5000.00F)
                assign.apply()
            }
        })
    }


    private lateinit var book: AppCompatButton

    private fun bookNow() {

        book = findViewById(R.id.bookNow)

        book.setOnClickListener {
            if (roomSelected) {
                val i = Intent(this, DisplayBookedFacility::class.java)
                startActivity(i)
                finish()
            } else {
                Toast.makeText(
                    this, "Please select type of room to proceed!!",
                    Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }


    // detail here is used for block
    override fun roomType(detail: String) {
        val assign = sharedPrefs.edit()
        assign.putString(residentialBlock, detail)
        assign.apply()
    }

    // detail1 here is room No and detail2 is floor no
    override fun room(detail1: String, detail2: String) {
        val assign = sharedPrefs.edit()
        assign.putString(roomNo, detail1)
        assign.putString(floorNo, detail2)
        assign.apply()
    }

    // detail here is used for mess location
    override fun messLocation(detail: String) {
        val assign = sharedPrefs.edit()
        assign.putString(messLocation, detail)
        assign.apply()
    }

    override fun messMenu(detail: String) {
        val assign = sharedPrefs.edit()
        assign.putString(messMenu, detail)
        assign.apply()
    }

}