package com.example.intenciones_angls

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoProducto {
    @Query("Select * from producto")
    fun todosProductos(): List<Producto>
    @Insert
    fun agregarProducto(vararg producto: Producto)
}