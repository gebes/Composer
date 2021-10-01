package io.gebes.composer.data.dao

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.gebes.composer.data.models.Dream

@Dao
interface DreamDao {

    @Insert
    fun insert(dream: Dream)

    @Query("SELECT * FROM dream_tbl")
    fun findAll(): Cursor;

    @Query("DELETE FROM dream_tbl WHERE id = :id")
    fun delete(id: Int)

    @Query("DELETE FROM dream_tbl")
    fun deleteAll()

    @Update
    fun update(dream: Dream)

}