package com.example.room_management_system.room

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import com.example.room_management_system.R

class Room : Fragment() {

    lateinit var v: View
    private var selectedSeat: ImageView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_room, container, false)
        createSeats()
        // Inflate the layout for this fragment
        return v
    }

    val bookedSeats = mutableSetOf("A1", "B3", "C4")

    private fun createSeats() {
        val gridLayout = v.findViewById<GridLayout>(R.id.roomLayout)
        for (row in 0 until gridLayout.rowCount) {
            for (col in 0 until gridLayout.columnCount) {
                val seat = ImageView(v.context)
                seat.layoutParams = GridLayout.LayoutParams().apply {
                    width = resources.getDimensionPixelSize(R.dimen.seat_size)
                    height = resources.getDimensionPixelSize(R.dimen.seat_size)
                    setMargins(4, 4, 4, 4)
                    columnSpec = GridLayout.spec(col, 1f)
                    rowSpec = GridLayout.spec(row, 1f)
                }
                val seatNumber = "${('A' + row)}${col + 1}"
                seat.tag = seatNumber
                if (bookedSeats.contains(seatNumber)) {
                    seat.setImageResource(R.drawable.booked_img)
                } else {
                    seat.setImageResource(R.drawable.available_img)
                }
                seat.setOnClickListener { onSeatSelected(it) }
                gridLayout.addView(seat)
            }
        }
    }

    fun onSeatSelected(view: View) {
        val clickedSeat = view as ImageView
        val seatNumber = clickedSeat.tag as String

        if (bookedSeats.contains(seatNumber)) {
            // seat is already booked, do nothing
            return
        }
        if (selectedSeat != null && selectedSeat != clickedSeat) {
            // deselect the previously selected seat
            selectedSeat?.isSelected = false
            selectedSeat?.setImageResource(R.drawable.available_img)
        }
        // select the clicked seat
        clickedSeat.isSelected = true
        clickedSeat.setImageResource(R.drawable.your_seat_img)
        selectedSeat = clickedSeat
    }
}