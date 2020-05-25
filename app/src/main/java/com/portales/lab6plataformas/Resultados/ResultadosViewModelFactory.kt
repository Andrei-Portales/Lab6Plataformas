package com.portales.lab6plataformas.Resultados

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.portales.lab6plataformas.database.GuestDatabaseDao


class ResultadosViewModelFactory(private val database: GuestDatabaseDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ResultadosViewModel::class.java)) {
            return ResultadosViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class") as Throwable
    }
}