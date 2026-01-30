package com.mlechko.weatherapp.data

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.android.gms.tasks.Tasks
import com.mlechko.weatherapp.domain.City
import com.mlechko.weatherapp.domain.LocationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class LocationRepositoryImpl(
    private val context: Context
): LocationRepository {

    private val client = LocationServices.getFusedLocationProviderClient(context)

    @SuppressLint("MissingPermission")
    override suspend fun getCityFromGps(): City? {
        if (!hasPermission()) return null

        return withContext(Dispatchers.IO) {
            try {
                val location = Tasks.await(
                    client.getCurrentLocation(
                        Priority.PRIORITY_HIGH_ACCURACY,
                        CancellationTokenSource().token
                    )
                )

                location?.let {
                    City(
                        lat = it.latitude,
                        lon = it.longitude
                    )
                }
            } catch (e: Exception) {
                null
            }
        }


    }

    private fun hasPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    companion object {

        private var instance: LocationRepositoryImpl? = null
        private val LOCK = Any()

        fun getInstance(context: Context): LocationRepositoryImpl {

            instance?.let { return it }

            synchronized(LOCK) {
                instance?.let { return it }

                return LocationRepositoryImpl(context).also { instance= it }
            }
        }
    }
}