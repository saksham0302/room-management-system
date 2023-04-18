package com.example.room_management_system

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class LoginPage : AppCompatActivity() {

    private lateinit var registrationNo: EditText
    private lateinit var password: EditText
    private lateinit var login: Button

    private lateinit var sharedPrefs: SharedPreferences
    private val loginFile = "Login File"
    private val regNum = "regNo"
    private val passwd = "pwd"

    private lateinit var dbRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        registrationNo = findViewById(R.id.registrationNo)
        password = findViewById(R.id.password)
        login = findViewById(R.id.btn_Login)

        login.setOnClickListener {
            loginEmployee()
        }
    }

    private fun loginEmployee() {

        sharedPrefs = getSharedPreferences(loginFile, Context.MODE_PRIVATE)

        val regNo = registrationNo.text.toString()
        val pwd = password.text.toString()

        if (regNo.isEmpty()) {
            registrationNo.error = "Enter the username"
        }
        if (pwd.isEmpty()) {
            this.password.error = "Enter the password"
        }

        if (pwd == (sharedPrefs.getString(passwd, "")) &&
            regNo.toInt() == sharedPrefs.getInt(regNum, 0)
        ) {

            val i = Intent(this, RoomReservation::class.java)
            startActivity(i)
            finish()
        } else {
            Toast.makeText(
                this, "Please check your registration number and password",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}