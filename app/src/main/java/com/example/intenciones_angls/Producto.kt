package com.example.intenciones_angls

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Producto (
    @PrimaryKey val id:Int,
    @ColumnInfo(name="nombre") val nombre:String,
    @ColumnInfo(name="precio")  val precio:Double
)