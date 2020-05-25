package com.portales.lab6plataformas.Registrar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.portales.lab6plataformas.database.GuestDatabaseDao
import java.lang.IllegalArgumentException

class RegistrarViewModelFactory(private val database: GuestDatabaseDao): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegistrarViewModel::class.java)) {
            return RegistrarViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}