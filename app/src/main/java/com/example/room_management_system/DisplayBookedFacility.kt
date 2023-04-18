package com.example.room_management_system

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DisplayBookedFacility : AppCompatActivity() {

    // access widgets from resource file
    lateinit var residential_facility: TextView
    lateinit var residential_block: TextView
    lateinit var floor_no: TextView
    lateinit var room_no: TextView
    lateinit var mess_type: TextView
    lateinit var mess_location: TextView
    lateinit var mess_menu: TextView
    lateinit var gym: TextView
    lateinit var laundry: TextView
    lateinit var net_payable_amount: TextView

    // access tags from shared prefs
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_booked_facility)

        residential_facility = findViewById(R.id.residential_facility)
        residential_block = findViewById(R.id.residential_block)
        floor_no = findViewById(R.id.floor_no)
        room_no = findViewById(R.id.room_no)
        mess_type = findViewById(R.id.mess_type)
        mess_location = findViewById(R.id.mess_location)
        mess_menu = findViewById(R.id.mess_menu)
        gym = findViewById(R.id.gym)
        laundry = findViewById(R.id.laundry)
        net_payable_amount = findViewById(R.id.net_payable_amount)

        sharedPrefs = getSharedPreferences(file, Context.MODE_PRIVATE)
        residential_facility.text = sharedPrefs.getString(residentialFacility, "Not Booked")
        residential_block.text = sharedPrefs.getString(residentialBlock, "Not Selected")
        floor_no.text = sharedPrefs.getString(floorNo, "Not Selected")
        room_no.text = sharedPrefs.getString(roomNo, "Not Selected")
        mess_type.text = sharedPrefs.getString(mess, "Not Opted")
        mess_location.text = sharedPrefs.getString(messLocation, "Not Selected")
        mess_menu.text = sharedPrefs.getString(messMenu, "Not Selected")
        gym.text = sharedPrefs.getString(gymFacility, "Not Opted")
        laundry.text = sharedPrefs.getString(laundryFacility, "Not Opted")

        val charges = sharedPrefs.getFloat(residentialCharges,0f) +
                sharedPrefs.getFloat(messCharges, 0f) +
                sharedPrefs.getFloat(gymFacilityCharges, 0f) +
                sharedPrefs.getFloat(laundryFacilityCharges, 0f)

        net_payable_amount.text = charges.toString()
    }
}