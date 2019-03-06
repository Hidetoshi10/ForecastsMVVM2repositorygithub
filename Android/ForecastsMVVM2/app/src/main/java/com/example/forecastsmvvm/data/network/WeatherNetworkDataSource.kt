package com.example.forecastsmvvm.data.network

import androidx.lifecycle.LiveData
import com.example.forecastsmvvm.data.db.network.response.CurrentWeatherResponse
import com.example.forecastsmvvm.data.db.network.response.FutureWeatherResponse

interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
    val downloadedFutureWeather: LiveData<FutureWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String,
        languageCode: String
    )
    suspend fun fetchFutureWeather(
        location: String,
        languageCode: String
    )
}