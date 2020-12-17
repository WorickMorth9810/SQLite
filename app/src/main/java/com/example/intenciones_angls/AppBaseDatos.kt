package com.example.intenciones_angls

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Producto::class], version = 1)
abstract class AppBaseDatos :RoomDatabase(){
    abstract fun productoDao(): DaoProducto
}