package com.example.room_management_system

interface ShareDetails {

    // detail here is used for block
    fun roomType(detail: String)

    // detail1 here is room No and detail2 is floor no
    fun room(detail1: String, detail2: String)

    // detail here is used for mess location
    fun messLocation(detail: String)

    // detail here is used for mess menu
    fun messMenu(detail: String)
}