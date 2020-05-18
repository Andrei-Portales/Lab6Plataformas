package com.portales.lab6plataformas

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface InvitadoDao {

    @Insert
    fun insert(invitado: Invitado)

    @Update
    fun update(invitado: Invitado)

    @Delete
    fun delete(invitado: Invitado)

    @Query("DELETE FROM Invitados")
    fun deleteallInvitados()

    @Query("SELECT * FROM Invitados")
    fun getAllInvitados(): LiveData<List<Invitado>>

}