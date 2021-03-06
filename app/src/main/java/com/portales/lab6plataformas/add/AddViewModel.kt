package com.portales.lab6plataformas.add

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.portales.lab6plataformas.database.Guest
import com.portales.lab6plataformas.database.GuestDatabaseDao
import com.portales.lab6plataformas.database.GuestRole
import com.portales.lab6plataformas.guest.GuestRoleDatabaseDao
import kotlinx.coroutines.*


class AddViewModel(val database: GuestDatabaseDao,
                   val databaseRole: GuestRoleDatabaseDao
) : ViewModel() {

    val name = MutableLiveData<String>()

    val phone = MutableLiveData<String>()

    val email = MutableLiveData<String>()

    val registered = MutableLiveData<Boolean>()

    val rolesList = databaseRole.getGuestRoles()

    private val viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun insertGuest(role: Any) {
        uiScope.launch {
            insert(role as GuestRole)
        }
    }

    private suspend fun insert(guestRole: GuestRole?) {
        withContext(Dispatchers.IO) {
            database.insert(
                Guest(name = name.value ?: "", phone = phone.value ?: "",
                email = email.value ?: "", registered = registered.value ?: false , role_id = guestRole?.roleId ?: 0L)
            )
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
