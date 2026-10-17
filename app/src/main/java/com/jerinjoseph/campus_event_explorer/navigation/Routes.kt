package com.jerinjoseph.campus_event_explorer.navigation

import kotlinx.serialization.Serializable

@Serializable
data object EventList

@Serializable
data class EventDetail(
    val eventId: Long
)