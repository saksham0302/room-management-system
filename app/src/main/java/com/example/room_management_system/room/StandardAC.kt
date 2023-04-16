package com.example.room_management_system.room

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.room_management_system.R

class StandardAC : Fragment() {

    lateinit var v: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //v =
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_standard_a_c, container, false)
    }

}