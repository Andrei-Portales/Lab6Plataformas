package com.portales.lab6plataformas.database

import androidx.room.Embedded

data class GuestWithRole (
    @Embedded
    val guest: Guest,

    val role: String,

    val iconIndex: Int

)