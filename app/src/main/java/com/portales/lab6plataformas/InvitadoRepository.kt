package com.portales.lab6plataformas

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData

class InvitadoRepository(application: Application) {

    private var invitadoDao:InvitadoDao
    private var invitados:LiveData<List<Invitado>>

    init {
        var database = InvitadoDatabase.getInstance(application)
        invitadoDao = database.InvitadoDao()
        invitados = invitadoDao.getAllInvitados()
    }

    fun insert(invitado: Invitado){
        InsertInvitadoAsyncTask(invitadoDao).execute(invitado)
    }

    fun update(invitado: Invitado){
        UpdateInvitadoAsyncTask(invitadoDao).execute(invitado)
    }

    fun delete (invitado: Invitado){
        DeleteInvitadoAsyncTask(invitadoDao).execute(invitado)
    }

    fun deleteAllIncitados(){
        DeleteAllInvitadoAsyncTask(invitadoDao).execute()
    }

    fun getInvitados():LiveData<List<Invitado>>{
        return invitados
    }

    companion object{
        class InsertInvitadoAsyncTask(invitadoDao: InvitadoDao): AsyncTask<Invitado,Void?,Void?>(){
            private var invitadoDao: InvitadoDao

            init {
                this.invitadoDao = invitadoDao
            }

            override fun doInBackground(vararg params: Invitado?): Void? {
                invitadoDao.insert(params[0] as Invitado)
                return null
            }
        }

        class UpdateInvitadoAsyncTask(invitadoDao: InvitadoDao): AsyncTask<Invitado,Void?,Void?>(){
            private var invitadoDao: InvitadoDao

            init {
                this.invitadoDao = invitadoDao
            }

            override fun doInBackground(vararg params: Invitado?): Void? {
                invitadoDao.update(params[0] as Invitado)
                return null
            }
        }

        class DeleteInvitadoAsyncTask(invitadoDao: InvitadoDao): AsyncTask<Invitado,Void?,Void?>(){
            private var invitadoDao: InvitadoDao

            init {
                this.invitadoDao = invitadoDao
            }

            override fun doInBackground(vararg params: Invitado?): Void? {
                invitadoDao.delete(params[0] as Invitado)
                return null
            }
        }

        class DeleteAllInvitadoAsyncTask(invitadoDao: InvitadoDao): AsyncTask<Void?,Void?,Void?>(){
            private var invitadoDao: InvitadoDao

            init {
                this.invitadoDao = invitadoDao
            }

            override fun doInBackground(vararg params: Void?): Void? {
                invitadoDao.deleteallInvitados()
                return null
            }
        }
    }

}