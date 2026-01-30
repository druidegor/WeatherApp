package com.mlechko.weatherapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [CityDbModel::class],
    version = 1,
    exportSchema = false
)
abstract class CityDatabase: RoomDatabase() {

    abstract fun cityDao(): CityDao

    companion object {

        private var instance: CityDatabase? = null

        private val LOCK = Any()

        fun getInstance(context: Context): CityDatabase {

            instance?.let {
                return it
            }

            synchronized(LOCK) {
                instance?.let { return it }

                return Room.databaseBuilder(
                    context = context,
                    klass = CityDatabase::class.java,
                    name = "city.db"
                ).build().also {
                    instance = it
                }
            }
        }
    }
}