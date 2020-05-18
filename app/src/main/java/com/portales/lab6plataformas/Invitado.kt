package com.portales.lab6plataformas

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Invitados")
class Invitado(nombre: String,tel:String,correo:String,rol:String) {

    @PrimaryKey(autoGenerate = true)
    var id:Int = 0

    var nombre :String = nombre

    var telefono:String = tel

    var correo: String = correo

    var rol: String = rol



}