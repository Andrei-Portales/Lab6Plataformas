package com.portales.lab6plataformas

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = arrayOf(Invitado::class), version = 1)
abstract class InvitadoDatabase : RoomDatabase(){

    abstract fun InvitadoDao():InvitadoDao

    companion object {
        @Volatile private var INSTANCE: InvitadoDatabase ? = null
        fun  getInstance(context:Context): InvitadoDatabase {
            if(INSTANCE == null){
                synchronized(this) {
                    INSTANCE =
                    Room.databaseBuilder(context.applicationContext,InvitadoDatabase::class.java,"invitado_database")
                        .fallbackToDestructiveMigration().addCallback(roomcallback).build()
                }
            }
            return INSTANCE!!
        }

        private var roomcallback : RoomDatabase.Callback = object :RoomDatabase.Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateDbAsuncTask(INSTANCE as InvitadoDatabase).execute()
            }
        }

        private class PopulateDbAsuncTask(db:InvitadoDatabase): AsyncTask<Void?,Void?,Void?>(){
            private var invitadoDao:InvitadoDao

            init {
                invitadoDao = db.InvitadoDao()
            }

            override fun doInBackground(vararg params: Void?): Void? {
                invitadoDao.insert(Invitado("Andrei","50569551","andreifan123@gmail.com","Estudiante"))
                return null
            }

        }


    }


}