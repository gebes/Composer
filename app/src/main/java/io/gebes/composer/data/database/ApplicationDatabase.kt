package io.gebes.composer.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.gebes.composer.data.dao.DreamDao
import io.gebes.composer.data.models.Dream

@Database(entities = [Dream::class], version = 1)
abstract class ApplicationDatabase : RoomDatabase() {
    abstract fun dreamDao(): DreamDao

    companion object {
        private var INSTANCE: ApplicationDatabase? = null

        fun getInstance(context: Context): ApplicationDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ApplicationDatabase::class.java,
                        "dream_tbl"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }

        }

    }
}