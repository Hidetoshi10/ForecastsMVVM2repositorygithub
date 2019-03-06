package com.example.forecastsmvvm.data.db.network.response

import com.example.forecastsmvvm.data.db.entity.CurrentWeatherEntry
import com.example.forecastsmvvm.data.db.entity.WeatherLocation
import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    val location: WeatherLocation,
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry

)