package com.example.room_management_system.room

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import com.example.room_management_system.R
import com.example.room_management_system.RoomReservation
import com.example.room_management_system.ShareDetails

class Room : Fragment() {

    // Variable to access the layout widgets in fragment
    lateinit var v: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Assigning inflater to the view variable
        v = inflater.inflate(R.layout.fragment_room, container, false)

        // Creating the attributes in grid layout
        createSeats()

        // Inflate the layout for this fragment
        return v
    }

    // Variable to assign images to the attributes of grid layout
    private var selectedSeat: ImageView? = null
    // Assigning the booked Seats manually
    val bookedSeats = mutableSetOf("1 1", "2 3", "4 4")

    private fun createSeats() {

        // Referring the widgets
        val gridLayout = v.findViewById<GridLayout>(R.id.roomLayout)

        // Building the grid layout
        for (row in 0 until gridLayout.rowCount) {
            for (col in 0 until gridLayout.columnCount) {

                // Assign image view to eah seat
                val seat = ImageView(v.context)

                // Set the layout parameters of each seat
                seat.layoutParams = GridLayout.LayoutParams().apply {
                    width = resources.getDimensionPixelSize(R.dimen.seat_width)
                    height = resources.getDimensionPixelSize(R.dimen.seat_height)
                    setMargins(2, 8, 2, 8)
                    columnSpec = GridLayout.spec(col, 1f)
                    rowSpec = GridLayout.spec(row, 1f)
                }

                // Assign the tag to each attribute
                val seatNumber = "${('1' + row)} ${col + 1}"
                seat.tag = seatNumber

                if (bookedSeats.contains(seatNumber)) {
                    seat.setImageResource(R.drawable.booked_img)
                } else {
                    seat.setImageResource(R.drawable.available_img)
                }

                seat.setOnClickListener {
                    onSeatSelected(it)
                }
                gridLayout.addView(seat)
            }
        }
    }

    fun onSeatSelected(view: View) {

        val clickedSeat = view as ImageView
        val seatNumber = clickedSeat.tag as String

        if (bookedSeats.contains(seatNumber)) {
            // Seat is already booked, do nothing
            return
        }

        else if (selectedSeat != null && selectedSeat != clickedSeat) {
            // Deselect the previously selected seat
            selectedSeat?.isSelected = false
            selectedSeat?.setImageResource(R.drawable.available_img)
        }

            // Select the clicked seat
            clickedSeat.isSelected = true
            clickedSeat.setImageResource(R.drawable.your_seat_img)
            selectedSeat = clickedSeat

            // Send room no to main activity
            val mai = activity as RoomReservation
            val arr = seatNumber.split("\\s".toRegex()).toTypedArray()
            mai.room(arr[0], arr[1])
    }
}