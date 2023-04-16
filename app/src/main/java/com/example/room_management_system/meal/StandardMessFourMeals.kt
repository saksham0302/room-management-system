package com.example.room_management_system.meal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.room_management_system.R

class StandardMessFourMeals : Fragment() {

    lateinit var v: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_standard_mess_four_meals, container, false)
        // Inflate the layout for this fragment
        return v
    }
}