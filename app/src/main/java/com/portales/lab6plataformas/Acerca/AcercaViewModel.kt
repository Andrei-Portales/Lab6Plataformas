package com.portales.lab6plataformas.Acerca

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AcercaViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Zevent"
    }
    val text: LiveData<String> = _text
}