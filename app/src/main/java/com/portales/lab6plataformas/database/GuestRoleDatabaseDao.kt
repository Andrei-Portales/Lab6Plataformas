package com.portales.lab6plataformas.guest

import androidx.lifecycle.LiveData
import androidx.room.*
import com.portales.lab6plataformas.database.GuestRole

@Dao
interface GuestRoleDatabaseDao {

    @Insert
    fun insert(guestRole: GuestRole)

    @Update
    fun update(guest: GuestRole)

    @Delete
    fun delete(guest: GuestRole)

    @Query("SELECT * FROM guest_role_table WHERE id = :key")
    fun getGuestRole(key:Long): LiveData<GuestRole>

    @Query("SELECT * FROM guest_role_table ORDER BY `order` DESC")
    fun getGuestRoles(): LiveData<List<GuestRole>>

    @Query("SELECT COUNT(*) FROM guest_role_table")
    fun getGuestRoleCount(): LiveData<Int>
}