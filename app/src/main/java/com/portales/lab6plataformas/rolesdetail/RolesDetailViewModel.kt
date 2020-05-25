package com.portales.lab6plataformas.rolesdetail

import androidx.lifecycle.ViewModel
import com.portales.lab6plataformas.guest.GuestRoleDatabaseDao

import kotlinx.coroutines.*

class RolesDetailViewModel(val database: GuestRoleDatabaseDao, val roleId: Long) : ViewModel() {

    val guestRole = database.getGuestRole(roleId)

    val viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun deleteGuestRole() {
        uiScope.launch {
            delete()
        }
    }

    private suspend fun delete() {
        withContext(Dispatchers.IO) {
            guestRole.value?.let { database.delete(it) }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}
