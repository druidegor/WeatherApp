package com.mlechko.weatherapp.di

import android.content.Context
import com.mlechko.weatherapp.data.LocationRepositoryImpl
import com.mlechko.weatherapp.data.cities.CityApiService
import com.mlechko.weatherapp.data.cities.CityDao
import com.mlechko.weatherapp.data.cities.CityDatabase
import com.mlechko.weatherapp.data.cities.CityRepositoryImpl
import com.mlechko.weatherapp.data.remote.WeatherApiService
import com.mlechko.weatherapp.data.remote.WeatherRepositoryImpl
import com.mlechko.weatherapp.domain.CityRepository
import com.mlechko.weatherapp.domain.LocationRepository
import com.mlechko.weatherapp.domain.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Singleton
    @Binds
    fun provideCityRepository(
        impl: CityRepositoryImpl
    ): CityRepository

    @Singleton
    @Binds
    fun provideLocationRepository(
        impl: LocationRepositoryImpl
    ): LocationRepository

    @Singleton
    @Binds
    fun provideWeatherRepository(
        impl: WeatherRepositoryImpl
    ): WeatherRepository

    companion object {


        @Singleton
        @Provides
        fun provideCityDatabase(
            @ApplicationContext context: Context
        ): CityDatabase {
            return CityDatabase.getInstance(context)
        }

        @Singleton
        @Provides
        fun provideCityDao(
            database: CityDatabase
        ): CityDao {
            return database.cityDao()
        }

        @Singleton
        @Provides
        fun provideCityApi(): CityApiService {
            return Retrofit.Builder()
                .baseUrl("https://nominatim.openstreetmap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CityApiService::class.java)
        }

        @Singleton
        @Provides
        fun provideWeatherApi(): WeatherApiService {
            return Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherApiService::class.java)
        }

    }
}