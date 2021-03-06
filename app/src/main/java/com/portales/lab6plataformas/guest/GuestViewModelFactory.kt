package com.portales.lab6plataformas.guest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lab_7.ui.guest.GuestViewModel
import com.portales.lab6plataformas.database.GuestDatabaseDao

import java.lang.IllegalArgumentException

class GuestViewModelFactory(private val database: GuestDatabaseDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GuestViewModel::class.java)) {
            return GuestViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}