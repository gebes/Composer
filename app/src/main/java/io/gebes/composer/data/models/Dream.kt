package io.gebes.composer.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dream_tbl")
data class Dream(
    @PrimaryKey(autoGenerate = true)
    private val id: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "description")
    val description: String,


)
