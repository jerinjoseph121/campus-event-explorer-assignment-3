package com.jerinjoseph.campus_event_explorer.data

import android.content.Context
import com.jerinjoseph.campus_event_explorer.R

data class CampusEvent(
    val id: Long,
    val title: String,
    val category: String,
    val location: String,
    val time: String,
    val description: String
)

fun getCampusEvents(context: Context): List<CampusEvent> = listOf(
    CampusEvent(
        id = 1L,
        title = context.getString(R.string.campus_event_one_title),
        category = context.getString(R.string.campus_event_one_category),
        location = context.getString(R.string.campus_event_one_location),
        time = context.getString(R.string.campus_event_one_time),
        description = context.getString(R.string.campus_event_one_description)
    ),
    CampusEvent(
        id = 2L,
        title = context.getString(R.string.campus_event_two_title),
        category = context.getString(R.string.campus_event_two_category),
        location = context.getString(R.string.campus_event_two_location),
        time = context.getString(R.string.campus_event_two_time),
        description = context.getString(R.string.campus_event_two_description)
    ),
    CampusEvent(
        id = 3L,
        title = context.getString(R.string.campus_event_three_title),
        category = context.getString(R.string.campus_event_three_category),
        location = context.getString(R.string.campus_event_three_location),
        time = context.getString(R.string.campus_event_three_time),
        description = context.getString(R.string.campus_event_three_description)
    ),CampusEvent(
        id = 4L,
        title = context.getString(R.string.campus_event_four_title),
        category = context.getString(R.string.campus_event_four_category),
        location = context.getString(R.string.campus_event_four_location),
        time = context.getString(R.string.campus_event_four_time),
        description = context.getString(R.string.campus_event_four_description)
    ),CampusEvent(
        id = 5L,
        title = context.getString(R.string.campus_event_five_title),
        category = context.getString(R.string.campus_event_five_category),
        location = context.getString(R.string.campus_event_five_location),
        time = context.getString(R.string.campus_event_five_time),
        description = context.getString(R.string.campus_event_five_description)
    ),CampusEvent(
        id = 6L,
        title = context.getString(R.string.campus_event_six_title),
        category = context.getString(R.string.campus_event_six_category),
        location = context.getString(R.string.campus_event_six_location),
        time = context.getString(R.string.campus_event_six_time),
        description = context.getString(R.string.campus_event_six_description)
    ),
    CampusEvent(
        id = 7L,
        title = context.getString(R.string.campus_event_seven_title),
        category = context.getString(R.string.campus_event_seven_category),
        location = context.getString(R.string.campus_event_seven_location),
        time = context.getString(R.string.campus_event_seven_time),
        description = context.getString(R.string.campus_event_seven_description)
    ),CampusEvent(
        id = 8L,
        title = context.getString(R.string.campus_event_eight_title),
        category = context.getString(R.string.campus_event_eight_category),
        location = context.getString(R.string.campus_event_eight_location),
        time = context.getString(R.string.campus_event_eight_time),
        description = context.getString(R.string.campus_event_eight_description)
    ),
    CampusEvent(
        id = 9L,
        title = context.getString(R.string.campus_event_nine_title),
        category = context.getString(R.string.campus_event_nine_category),
        location = context.getString(R.string.campus_event_nine_location),
        time = context.getString(R.string.campus_event_nine_time),
        description = context.getString(R.string.campus_event_nine_description)
    ),CampusEvent(
        id = 10L,
        title = context.getString(R.string.campus_event_ten_title),
        category = context.getString(R.string.campus_event_ten_category),
        location = context.getString(R.string.campus_event_ten_location),
        time = context.getString(R.string.campus_event_ten_time),
        description = context.getString(R.string.campus_event_ten_description)
    ),
    CampusEvent(
        id = 11L,
        title = context.getString(R.string.campus_event_eleven_title),
        category = context.getString(R.string.campus_event_eleven_category),
        location = context.getString(R.string.campus_event_eleven_location),
        time = context.getString(R.string.campus_event_eleven_time),
        description = context.getString(R.string.campus_event_eleven_description)
    ),
    CampusEvent(
        id = 12L,
        title = context.getString(R.string.campus_event_twelve_title),
        category = context.getString(R.string.campus_event_twelve_category),
        location = context.getString(R.string.campus_event_twelve_location),
        time = context.getString(R.string.campus_event_twelve_time),
        description = context.getString(R.string.campus_event_twelve_description)
    )
)