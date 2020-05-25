package com.portales.lab6plataformas.rolesdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.portales.lab6plataformas.guest.GuestRoleDatabaseDao


class RolesDetailViewModelFactory(private val database: GuestRoleDatabaseDao,
                                  private val roleId:Long): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RolesDetailViewModel::class.java)) {
            return RolesDetailViewModel(database, roleId) as T
        }
        throw IllegalAccessException("Unknown ViewModel class")
    }
}