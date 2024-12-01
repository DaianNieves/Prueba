package com.example.project1.data.model.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.project1.data.model.model.ServiceEntity

@Dao
interface ServiceDao {

    @Query("SELECT * FROM ServiceEntity")
    fun getAll(): List<ServiceEntity>

    @Query("SELECT * FROM ServiceEntity WHERE id=:ServiceId")
    fun show(ServiceId:Int):ServiceEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(Service:List<ServiceEntity>)

    @Delete
    fun delete (service:ServiceEntity)

}