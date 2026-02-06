package com.mlechko.weatherapp.data.cities

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [CityDbModel::class],
    version = 3,
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
                ).fallbackToDestructiveMigration(dropAllTables = true)
                    .build().also {
                    instance = it
                }
            }
        }
    }
}