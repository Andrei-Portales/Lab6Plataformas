package com.portales.lab6plataformas.guestdetail

import androidx.lifecycle.ViewModel
import com.portales.lab6plataformas.database.GuestDatabaseDao
import kotlinx.coroutines.*

class GuestDetailViewModel(val database: GuestDatabaseDao, val guestId: Long) : ViewModel() {

    val guest = database.getGuest(guestId)

    val viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)


    fun deleteGuest() {
        uiScope.launch {
            delete()
        }
    }

    private suspend fun delete() {
        withContext(Dispatchers.IO) {
            guest.value?.let { database.delete(it) }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}
