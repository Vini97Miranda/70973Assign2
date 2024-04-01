package com.stu70973.a70973assign2

data class dataType (
        val name: String,
        val imageId: Int,
        val certification: Int,
        val description: String,
        val starring: Array<String>,
        val running_time_mins: Int,
        var seats_remaining: Int,
        var seats_selected: Int,
        val id: Int,
    )
