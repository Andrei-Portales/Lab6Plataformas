package com.portales.lab6plataformas

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class InvitadoViewModel(application: Application): AndroidViewModel(application) {


    private var repository:InvitadoRepository
    private var allInvitados : LiveData<List<Invitado>>

    init {
        repository = InvitadoRepository(application)
        allInvitados = repository.getInvitados()
    }

    fun insert(invitado: Invitado){
        repository.insert(invitado)
    }

    fun update(invitado: Invitado){
        repository.update(invitado)
    }

    fun delete(invitado: Invitado){
        repository.delete(invitado)
    }

    fun deleteAllInvitados(){
        repository.deleteAllIncitados()
    }

    fun getAllInvitados():LiveData<List<Invitado>>{
        return allInvitados
    }


}