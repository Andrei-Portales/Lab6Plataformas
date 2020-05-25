package com.portales.lab6plataformas.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.portales.lab6plataformas.database.GuestDatabaseDao
import com.portales.lab6plataformas.guest.GuestRoleDatabaseDao

import java.lang.IllegalArgumentException

class AddViewModelFactory(private val database: GuestDatabaseDao,
                          private val databaseRole: GuestRoleDatabaseDao
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddViewModel::class.java)) {
            return AddViewModel(database, databaseRole) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }

}