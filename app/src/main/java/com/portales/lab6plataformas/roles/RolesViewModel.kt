package com.portales.lab6plataformas.roles

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.portales.lab6plataformas.guest.GuestRoleDatabaseDao
import java.lang.StringBuilder

class RolesViewModel(val database: GuestRoleDatabaseDao) : ViewModel() {

    val roles = database.getGuestRoles()

   private val _guestRoleClicked = MutableLiveData<Long>()
    val guestRoleClicked: LiveData<Long>
    get() = _guestRoleClicked

    fun onGuestRolesClicked(roleId: Long) {
        _guestRoleClicked.value = roleId
    }

    fun onGuestRolesClickedCompleted(){
        _guestRoleClicked.value = null
    }
}