package com.example.lab_7.ui.guest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

import com.portales.lab6plataformas.database.GuestDatabaseDao
import java.lang.StringBuilder

class GuestViewModel(val database: GuestDatabaseDao) : ViewModel() {

    val guests = database.getGuestsWithRole()

    private val _guestClicked = MutableLiveData<Long>()
    val guestClicked: LiveData<Long>
        get() = _guestClicked

    fun onGuestClicked(roleId: Long) {
        _guestClicked.value = roleId
    }

    fun onGuestClickedCompleted(){
        _guestClicked.value = null
    }

}