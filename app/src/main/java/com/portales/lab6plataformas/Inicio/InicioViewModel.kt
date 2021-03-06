package com.portales.lab6plataformas.Inicio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InicioViewModel : ViewModel() {

    // Event to go to Register Fragment
    private val _eventGoToRegister = MutableLiveData<Boolean>()
    val eventGoToRegister: LiveData<Boolean>
        get() = _eventGoToRegister

    init {

    }

    fun onGoToRegisterComplete() {
        _eventGoToRegister.value = false
    }

    fun onGoToRegister() {
        _eventGoToRegister.value = true
    }

}